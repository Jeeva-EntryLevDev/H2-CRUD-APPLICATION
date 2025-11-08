package com.example.SpringBootJPARepositoryH2.service;


import com.example.SpringBootJPARepositoryH2.model.Student;
import com.example.SpringBootJPARepositoryH2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student findStudent(Long id){
        return studentRepository.findById(id).orElse(null);     // or throw an exception if preferred
    }

    public List<Student> findByName(String name){
        return studentRepository.findByName(name);
    }

    public void deleteRecord(Long id){
        studentRepository.deleteById(id);
    }
}
