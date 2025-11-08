package com.example.SpringBootJPARepositoryH2.controller;


import com.example.SpringBootJPARepositoryH2.model.Student;
import com.example.SpringBootJPARepositoryH2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ControllerTriggering {
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String welcomeMessage(){
        return "welcome to the JPA Repository practice program";
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping("/students")
    public List<Student> getStudetsList(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Long id){
        return studentService.findStudent(id);
    }

    @GetMapping("/students/search")
    public List<Student> getStudentByString(@RequestParam String name){
        return studentService.findByName(name);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteRecord(id);
    }

}
