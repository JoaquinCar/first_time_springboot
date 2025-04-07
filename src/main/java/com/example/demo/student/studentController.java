package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This annotation is used to create a RESTful web service
@RequestMapping(path = "api/v1/student")
public class studentController {
    @Autowired // This annotation is used to let Spring know that we want to inject the studentService dependency into the studentController class.
    private final studentService studentService;


    public studentController(studentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping// This annotation is used to map HTTP GET requests to this method, returning a list of students
    public List<student> getStudents(){
        return studentService.getStudents();
    }
    @PostMapping // This annotation is used to map HTTP POST requests to this method, adding a new student
    public void registerNewStudent(@RequestBody student student) { //request body is used to get the data from the client
        studentService.addNewStudent(student);
    }
}
