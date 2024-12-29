package com.ust.Schoolservice.Service;

import com.ust.Schoolservice.Entity.Student;
import com.ust.Schoolservice.Repository.StudentRepo;
import com.ust.Schoolservice.dto.Coursedto;
import com.ust.Schoolservice.dto.Responsedto;
import com.ust.Schoolservice.dto.Studentdto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;

    @Autowired
    private WebClient webClient;

    //add student
    public Student addstudent(Student student) {
        return repo.save(student);
    }

    //get all student
    public List<Student> getallstudent() {
        return repo.findAll();
    }

    //get std by email
    public Student getByEmail(String email) {
        return repo.findByEmail(email);
    }

    //update
    public Student updatebyid(Long id, Student student) {
        student.setId(id);
        return repo.save(student);
    }

    //delete
    public void deletestudent(Long id) {
        repo.deleteById(id);
    }
    public Optional<Student> getstudenstByCourse(String sid) {
        return repo.findBysid(sid);
    }

    @CircuitBreaker(name = "flightService", fallbackMethod = "fallbackGetCourse")
    public Responsedto getcourse(String sid) {
        Responsedto responseDto = new Responsedto();
        Student student = repo.findBysid(sid).orElseThrow(() -> new RuntimeException("Student not found"));
        Studentdto studentdto = mapToStudentdto(student);
        List<Coursedto> coursedtolist = webClient.get()
                .uri("http://localhost:8081/api/" + student.getSid())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Coursedto>>() {})
                .block();
        responseDto.setStudentdto(studentdto);
        responseDto.setCoursedto(coursedtolist);

        return responseDto;

    }


    public Responsedto fallbackGetCourse(String sid, Throwable throwable) {
       // System.out.println("Fallback called for SID: " + sid);
        return new Responsedto();
    }

    private Studentdto mapToStudentdto(Student student) {
        Studentdto studentdto = new Studentdto();
        studentdto.setId(student.getId());
        studentdto.setEmail(student.getEmail());
        studentdto.setName(student.getName());
        studentdto.setSid(student.getSid());
        return studentdto;
    }

}