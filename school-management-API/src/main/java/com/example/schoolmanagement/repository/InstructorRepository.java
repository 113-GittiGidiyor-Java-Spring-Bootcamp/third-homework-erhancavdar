package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Course;
import com.example.schoolmanagement.entity.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Long> {
    Optional<Instructor> findInstructorByName(String name);
    void deleteByName(String name);
}
