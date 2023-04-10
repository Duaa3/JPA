package com.INMHibernateJPA.JPAHibernateINM.Service;
import com.INMHibernateJPA.JPAHibernateINM.Model.Student;
import com.INMHibernateJPA.JPAHibernateINM.Repository.StudentRepository;
import com.INMHibernateJPA.JPAHibernateINM.Repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//indicates that this class is a Spring-managed service bean.
@Service
public class StudentService {
    //perform CRUD operations on  student entities
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getAStudent(int id) {
        return studentRepository.findById(id);
    }

    public Student creatStudent(Student currStudent) {
        return studentRepository.save(currStudent);
    }

    public Student uptdateStudent(int id, Student upToDateStudent) {
        Optional<Student> foundStudent = studentRepository.findById(id);
        if (foundStudent.isPresent()) {
            Student existingStudent = foundStudent.get();
            existingStudent.setName(upToDateStudent.getName());
            existingStudent.setEmail(upToDateStudent.getEmail());
            return studentRepository.save(existingStudent);
        } else {
            return null;
        }
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
}

