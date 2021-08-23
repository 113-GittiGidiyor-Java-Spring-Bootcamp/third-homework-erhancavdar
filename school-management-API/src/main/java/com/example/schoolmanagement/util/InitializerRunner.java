package com.example.schoolmanagement.util;

import com.example.schoolmanagement.entity.Instructor;
import com.example.schoolmanagement.entity.PermanentInstructor;
import com.example.schoolmanagement.entity.Student;
import com.example.schoolmanagement.service.CourseService;
import com.example.schoolmanagement.service.InstructorService;
import com.example.schoolmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializerRunner implements CommandLineRunner {
    InstructorService instructorService;
    StudentService studentService;
    CourseService courseService;

    @Autowired
    public InitializerRunner(InstructorService instructorService, StudentService studentService, CourseService courseService) {
        this.instructorService = instructorService;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Entities



    }
}
