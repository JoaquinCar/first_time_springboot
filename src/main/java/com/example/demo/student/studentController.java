package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class studentController {
    @Autowired // This annotation is used to let Spring know that we want to inject the studentService dependency into the studentController class.
    private final studentService studentService;


    public studentController(studentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<student> getStudents(){
       return studentService.getStudents();
    }
}
