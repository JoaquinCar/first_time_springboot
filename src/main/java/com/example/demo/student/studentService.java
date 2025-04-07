package com.example.demo.student;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addNewStudent(student student) {
        //optional because the email may not exist
        Optional<student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        // This method checks if a student with the same email already exists in the database
        if (studentOptional.isPresent()) { //if exists
            throw new IllegalStateException("Email already taken"); //exception
        } else {
            studentRepository.save(student); // This method saves the new student to the database, save is a method of the studentRepository
            System.out.println("Student added: " + student.getName() + " with email: " + student.getEmail());
        }
    }

    public void deleteStudent(Long studentId) {
        studentRepository.findById(studentId);
            boolean exists = studentRepository.existsById(studentId);
            if (!exists) { //if not exists
                throw new IllegalStateException("Student with id " + studentId + " does not exist");
            }
            studentRepository.deleteById(studentId); // This method deletes the student with the given ID from the database
            System.out.println("Student with id " + studentId + " deleted");
    }
    @Transactional // This annotation is used to indicate that this method should be executed within a transaction
    // This means that if any part of the method fails, the entire transaction will be rolled back
    public void updateStudent(Long studentId, String studentName, String email) {
        Optional<student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            student student = optionalStudent.get(); // This method retrieves the student with the given ID from the database

            if (studentName != null && !studentName.isEmpty() && !studentName.equals(student.getName())) {
                student.setName(studentName); // This method updates the name of the studen
            }
            if (email != null && !email.isEmpty() && !email.equals(student.getEmail())) {

                Optional<student> studentOptional = studentRepository.findStudentByEmail(email);
                if (studentOptional.isPresent()) {
                    throw new IllegalStateException("Email already taken");
                }
                student.setEmail(email); // This method updates the email of the student
            }
            System.out.println("Student updated: " + student.getName() + " with email: " + student.getEmail());
        }
        else {
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }
        }

}


