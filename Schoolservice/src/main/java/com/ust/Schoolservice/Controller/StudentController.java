package com.ust.Schoolservice.Controller;

import com.ust.Schoolservice.Entity.Student;
import com.ust.Schoolservice.Service.StudentService;
import com.ust.Schoolservice.dto.Responsedto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping("/addstudent/")
    public Student addstudent (@RequestBody Student student){
        return service.addstudent(student);
    }

    @GetMapping("/getallstudent")
    public List<Student> getallstudent(){
        return service.getallstudent();
    }

    @GetMapping("/getby/{email}")
    public ResponseEntity<Student> getByEmail(@PathVariable String email){
        Student student = service.getByEmail(email);
        return student != null? ResponseEntity.ok(student):ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updatestudent(@PathVariable Long id, @RequestBody Student student){
        return  ResponseEntity.ok(service.updatebyid(id,student));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Student> deleteStudent (@PathVariable Long id){
        service.deletestudent(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{sid}")
    public ResponseEntity<Responsedto> getUser(@PathVariable("sid") String sid){
        Responsedto responseDto = service.getcourse(sid);
        return ResponseEntity.ok(responseDto);
    }



















}
