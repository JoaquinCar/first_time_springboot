package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service // This annotation is used to let Spring know that this class is a service class.
public class studentService {
    private final studentRepository studentRepository;

    @Autowired // This annotation is used to inject the studentRepository bean into this class.
    //When Spring creates an instance of studentService, it will automatically provide
    // an instance of studentRepository to the constructor,
    // ensuring that studentService has access to the repository for database operations.
    public studentService(studentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    public List<student> getStudents() {
        return studentRepository.findAll();
    }
}


