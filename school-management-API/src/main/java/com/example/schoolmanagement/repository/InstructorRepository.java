package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Long> {
}
