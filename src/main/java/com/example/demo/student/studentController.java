package com.example.demo.student;

import jakarta.transaction.Transactional;
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
    // http://localhost:8080/api/v1/student/1?name=arroyo
    @GetMapping// T// Responde a una petición GET (leer datos)
    public List<student> getStudents(){ //devuelve una lista de estudiantes
        return studentService.getStudents();
    }
    // http://localhost:8080/api/v1/student
    @PostMapping // This annotation is used to map HTTP POST requests to this method, adding a new student (crear datos)
    public void registerNewStudent(@RequestBody student student) { //request body is used to get the data from the client
        //@RequestBody Le dice a Spring: "toma el contenido del cuerpo (body) de la solicitud HTTP y conviértelo en un objeto Java (student)".
        //Es decir, ese JSON que mandas desde Postman o el frontend lo convierte automáticamente en un objeto student.
        studentService.addNewStudent(student);

    }
    // http://localhost:8080/api/v1/student/1
    @DeleteMapping(path = "{studentId}") // This annotation is used to map HTTP DELETE requests to this method, deleting a student by ID
    //Le dice a Spring: "Toma el valor que viene en la URL en lugar de {studentId} y guárdalo en la variable id".
    public void deleteStudent(@PathVariable("studentId") Long studentId) { //path variable is used to get the id from the URL
        studentService.deleteStudent(studentId);

    }
 // http://localhost:8080/api/v1/student/1?name=arroyo 1 = id ? name=arroyo
    @PutMapping(path = "{studentId}") // This annotation is used to map HTTP PUT requests to this method, updating a student by ID
    public void updateStudent(@PathVariable("studentId") Long studentId,@RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        //@requestParam is used to get the data from the URL, required = false means that the parameter is optional
        studentService.updateStudent(studentId,name, email);

    }

}
