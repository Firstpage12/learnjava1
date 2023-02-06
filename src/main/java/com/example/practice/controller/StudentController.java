package com.example.practice.controller;

import com.example.practice.model.Student;
import com.example.practice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/allstudents")
    public List<Student> getAllStudents(){
        return this.studentService.getStudents();
    }

    @PostMapping("/createstudent")
    public String createStudent(@RequestBody Student student){
        return this.studentService.createStudent(student);
    }
    //delete
    @DeleteMapping("/deletestudent")
    public String deleteStudent(@PathVariable int id){
        return this.studentService.deleteStudent(id);
    }


    //update

    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@RequestBody Student newstudent, @PathVariable int id){return this.studentService.updateStudent(newstudent,id);}

    //getbyid

    @GetMapping("/getstudent/{id}")
    public Student getStudentById(@PathVariable int id){return this.studentService.getStudenyById(id);}


}
