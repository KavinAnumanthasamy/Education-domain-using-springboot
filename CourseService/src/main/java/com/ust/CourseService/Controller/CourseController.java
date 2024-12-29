package com.ust.CourseService.Controller;

import com.ust.CourseService.Entity.Course;
import com.ust.CourseService.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseService service;

    @PostMapping("/addcourse")
    public Course addcourse(@RequestBody Course course){
        return service.addcourse(course);
    }
    @GetMapping("/getallcourse")
    public List<Course> getallCourse(){
        return service.getallCourse();
    }

    @GetMapping("/getby/{coursename}")
    public ResponseEntity< Course> getBycoursename(@PathVariable String coursename){
        Course course = service.getBycoursename(coursename);
        return course != null? ResponseEntity.ok(course):ResponseEntity.notFound().build();
    }
    @PutMapping("/{courseid}")
    public ResponseEntity<Course> updatecourse(@PathVariable Long courseid, @RequestBody Course course){
        return  ResponseEntity.ok(service.updatebyid(courseid,course));
    }

    @DeleteMapping("/{courseid}")
    public  ResponseEntity<Course> deletecourse(@PathVariable Long courseid){
        service.deletecourse(courseid);
        return ResponseEntity.noContent().build();
    }
}
