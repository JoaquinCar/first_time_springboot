package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface studentRepository extends JpaRepository <student, Long> { //student because is the class we want to work with name and Long is the type of the primary key
    // This interface extends JpaRepository, which provides CRUD operations for the student entity
    // The first parameter is the entity type (student) and the second parameter is the type of the primary key (Long)
    // No additional methods are needed as JpaRepository provides all the necessary methods

    //SELECT * FROM student WHERE email = ?;
    @Query("SELECT s FROM student s WHERE s.email = ?1")
    // This annotation is used to define a custom query
    // The query selects a student from the database where the email matches the provided parameter
    // The ?1 indicates that the first parameter of the method will be used in the query
    // The method returns an Optional<student>, which means it may or may not return a student object
    // This is useful for handling cases where the email does not exist in the database
    Optional<student> findStudentByEmail(String email);

}
