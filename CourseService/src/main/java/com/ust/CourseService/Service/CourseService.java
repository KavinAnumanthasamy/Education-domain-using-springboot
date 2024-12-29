package com.ust.CourseService.Service;

import com.ust.CourseService.Entity.Course;
import com.ust.CourseService.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository repo;

    public Course addcourse(Course course){
        return repo.save(course);
    }
    //get all student
    public List<Course> getallCourse(){
        return repo.findAll();
    }
    //get std by email
    public Course getBycoursename(String coursename){
        return repo.findBycoursename(coursename);
    }
    //update
    public Course updatebyid(Long courseid,Course course){
        course.setCourseid(courseid);
        return repo.save(course);
    }
    //delete
    public void deletecourse (Long courseid){
        repo.deleteById(courseid);
    }
}
