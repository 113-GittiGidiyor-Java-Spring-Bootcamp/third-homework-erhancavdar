package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.entity.Course;
import com.example.schoolmanagement.entity.Student;
import com.example.schoolmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable long id){
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student){
        return new ResponseEntity<>(studentService.save(student),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        studentService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody Student student){
        studentService.update(student);
    }
}
