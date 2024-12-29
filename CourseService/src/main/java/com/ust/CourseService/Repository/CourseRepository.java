package com.ust.CourseService.Repository;

import com.ust.CourseService.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long > {
    Course findBycoursename(String coursename);

}
