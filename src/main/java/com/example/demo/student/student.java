package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
@Entity // This annotation specifies that the class is an entity and is mapped to a database table
@Table // This annotation specifies the name of the table in the database
public class student {
    @Id // This annotation specifies the primary key of the entity
    @SequenceGenerator(  // This annotation specifies the generator for the primary key
            name = "student_sequence", // The name of the sequence generator
            sequenceName = "student_sequence", // The name of the sequence in the database
            allocationSize = 1 // The number of values to allocate at a time
    )
    @GeneratedValue( // This annotation specifies the strategy for generating the primary key
            strategy = GenerationType.SEQUENCE, // The strategy for generating the primary key
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob; // dob = date of birth
    private Integer age;



    public student(){
    }

    public student(Long id,
                   String name,
                   String email,
                   LocalDate dob,
                   Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public student(String name,
                   String email,
                   LocalDate dob,
                   Integer age) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }
    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Integer getAge() {
        return age;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return STR."student{id=\{id}, name='\{name}', email='\{email}', dob=\{dob}, age=\{age}}";
    }
}
