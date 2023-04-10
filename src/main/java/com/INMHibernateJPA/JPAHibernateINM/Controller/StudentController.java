package com.INMHibernateJPA.JPAHibernateINM.Controller;

import com.INMHibernateJPA.JPAHibernateINM.Model.Student;
import com.INMHibernateJPA.JPAHibernateINM.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // GET to retrieve all Student
    @GetMapping
    public List<Student> getStudent(){
        return studentService.getAllStudents();
    }

    // GET request to retrieve specific Student by ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable(name = "id") int id){
        Optional<Student> student = studentService.getAStudent(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST request to create a new Student
    @PostMapping
    public ResponseEntity<Student> creatStudent(@Valid @RequestBody Student currStudent){
        Student newStudent = studentService.creatStudent(currStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }

    // PUT request to update an existing Student by ID
    @PutMapping(path = "/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(name = "id") int id, @RequestBody Student currStudent){
        Student updatedStudent = studentService.uptdateStudent(id, currStudent);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE request to delete a specific Student by ID
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable(name = "id") int id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}