package com.INMHibernateJPA.JPAHibernateINM.Controller;
import com.INMHibernateJPA.JPAHibernateINM.Model.Teacher;
import com.INMHibernateJPA.JPAHibernateINM.Service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    // GET to retrieve all teachers
    @GetMapping
    public List<Teacher> getTeacher(){
        return teacherService.getAllTeacher();
    }

    // GET request to retrieve specific teacher by ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable(name = "id") int id){
        Teacher teacher = teacherService.getATeacher(id);
        if (teacher != null) {
            return ResponseEntity.ok(teacher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST request to create a new teacher
    @PostMapping
    public ResponseEntity<Teacher> creatTeacher(@Valid @RequestBody Teacher currTeacher){
        Teacher newTeacher = teacherService.creatTeacher(currTeacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTeacher);
    }

    // PUT request to update an existing teacher by ID
    @PutMapping(path = "/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable(name = "id") int id, @RequestBody Teacher currTeacher){
        Teacher updatedTeacher = teacherService.uptdateTeacher(id, currTeacher);
        if (updatedTeacher != null) {
            return ResponseEntity.ok(updatedTeacher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE request to delete a specific teacher by ID
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable(name = "id") int id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}

