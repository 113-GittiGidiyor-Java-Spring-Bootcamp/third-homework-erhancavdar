package com.example.schoolmanagement.service.concrete;

import com.example.schoolmanagement.entity.Student;
import com.example.schoolmanagement.repository.StudentRepository;
import com.example.schoolmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().iterator().forEachRemaining(students::add);
        return students;
    }

    @Override
    public Student findById(long id) {
        return studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("User not found."));
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public void delete(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Student student) {
        studentRepository.save(student);
    }
}
