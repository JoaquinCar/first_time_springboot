package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository <student, Long> { //student because is the class we want to work with name and Long is the type of the primary key
    // This interface extends JpaRepository, which provides CRUD operations for the student entity
    // The first parameter is the entity type (student) and the second parameter is the type of the primary key (Long)
    // No additional methods are needed as JpaRepository provides all the necessary methods



}
