package com.ust.Schoolservice.Repository;

import com.ust.Schoolservice.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByEmail(String email);
   Optional<Student> findBysid (String sid);


}
