package com.example.practice.service;

import com.example.practice.model.Student;
import com.example.practice.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    //Create New student details

    public String createStudent(Student student){
        if(this.studentRepo.existsById(student.getId())){
            return "Student already exists";
        }
        else{
            this.studentRepo.save(student);
            return "Student details are saved.";
        }
    }

    //get all student details

    public List<Student> getStudents(){
        return this.studentRepo.findAll();

    }

    //delete student

    public String deleteStudent(int id){
        this.studentRepo.deleteById(id);
        return "record deleted";
    }

    //update student

    public Student updateStudent(Student newstudent,int id){
        return studentRepo.findById(id)
                .map(student -> {
                    student.setName(newstudent.getName());
                    student.setAge(newstudent.getAge());
                    return studentRepo.save(student);
                })
                .orElseGet(() -> {
                    newstudent.setId(id);
                    return studentRepo.save(newstudent);
                });
    }

    //get student by id

    public Student getStudenyById(int id){
       return this.studentRepo.findById(id).orElse(null);


    }



}
