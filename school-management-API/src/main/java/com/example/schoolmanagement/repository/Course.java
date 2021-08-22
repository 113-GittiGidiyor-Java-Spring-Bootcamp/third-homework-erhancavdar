package com.example.schoolmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Course extends CrudRepository<Course,Long> {
}
