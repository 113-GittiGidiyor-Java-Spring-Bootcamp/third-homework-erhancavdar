package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Course;
import com.example.schoolmanagement.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    Optional<Student> findStudentByName(String name);
    void deleteByName(String name);
}
