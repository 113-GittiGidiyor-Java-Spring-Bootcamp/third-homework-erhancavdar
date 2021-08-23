package com.example.schoolmanagement.service.concrete;

import com.example.schoolmanagement.entity.Instructor;
import com.example.schoolmanagement.repository.InstructorRepository;
import com.example.schoolmanagement.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional(readOnly = true)
public class InstructorServiceImpl implements InstructorService {
    InstructorRepository instructorRepository;
    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> findAll() {
        List<Instructor> instructors = new ArrayList<>();
        instructorRepository.findAll().forEach(instructors::add);
        return instructors;
    }

    @Override
    public Instructor findById(long id) {

        return instructorRepository.findById(id).orElseThrow(()->new IllegalArgumentException("User not found."));
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor findByName(String name) {
        return instructorRepository.findInstructorByName(name).orElseThrow(()->new IllegalArgumentException("User not found."));
    }

    @Override
    public void deleteByName(String name) {
        instructorRepository.deleteByName(name);
    }

    @Override
    @Transactional
    public void delete(long id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public void delete(Instructor instructor) {
        instructorRepository.delete(instructor);
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        instructorRepository.save(instructor);
    }
}
