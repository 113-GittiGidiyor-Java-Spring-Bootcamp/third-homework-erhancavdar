package com.example.schoolmanagement.util;

import com.example.schoolmanagement.entity.*;
import com.example.schoolmanagement.service.CourseService;
import com.example.schoolmanagement.service.InstructorService;
import com.example.schoolmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        Instructor instructor = VisitingResearcher.builder()
                .name("Ahmet")
                .phoneNumber("123123123")
                .hourlySalary(42.0F)
                .build();
        Instructor instructor2 = PermanentInstructor.builder()
                .name("Osman")
                .phoneNumber("073123123")
                .fixedSalary(2597.0F)
                .build();
        Instructor instructor3 = VisitingResearcher.builder()
                .name("Ahmet")
                .phoneNumber("812123123")
                .hourlySalary(50.0F)
                .build();

        Course course = Course.builder()
                .name("Math")
                .creditScore(4.0F)
                .courseCode("M101")
                .build();
        Course course1 = Course.builder()
                .name("Physics")
                .creditScore(5.0F)
                .courseCode("P101")
                .build();
        Course course2 = Course.builder()
                .name("Chemistry")
                .creditScore(5.0F)
                .courseCode("C101")
                .build();

        Student student = Student.builder()
                .name("Ahmet")
                .address("Sarıyer")
                .birthday(LocalDate.of(2000,12,26))
                .gender(Gender.MALE)
                .build();
        Student student1 = Student.builder()
                .name("Osman")
                .address("Sarıyer")
                .birthday(LocalDate.of(2000,12,26))
                .gender(Gender.MALE)
                .build();

        Student student2 = Student.builder()
                .name("Ayşe")
                .address("Sarıyer")
                .birthday(LocalDate.of(2000,12,26))
                .gender(Gender.FEMALE)
                .build();
        // Save
        instructorService.save(instructor);
        instructorService.save(instructor2);
        instructorService.save(instructor3);

        courseService.save(course);
        courseService.save(course2);
        courseService.save(course1);

        studentService.save(student);
        studentService.save(student1);
        studentService.save(student2);


    }
}
