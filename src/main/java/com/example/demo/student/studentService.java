package com.example.demo.student;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service // This annotation is used to let Spring know that this class is a service class.
public class studentService {

        public List<student> getStudents(){
            return List.of(new student(1L,"kino", "kino@gmail.com", LocalDate.of(2006, Month.JUNE,10),18));
        }
    }

