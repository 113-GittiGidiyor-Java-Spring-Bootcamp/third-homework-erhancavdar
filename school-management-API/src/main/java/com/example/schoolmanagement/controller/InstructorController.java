package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.entity.Course;
import com.example.schoolmanagement.entity.Instructor;
import com.example.schoolmanagement.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    InstructorService instructorService;
    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @GetMapping
    public ResponseEntity<List<Instructor>> findAll(){
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findById(@PathVariable long id){
        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Instructor> save(@RequestBody Instructor instructor){
        return new ResponseEntity<>(instructorService.save(instructor),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        instructorService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody Instructor instructor){
        instructorService.update(instructor);
    }
}
