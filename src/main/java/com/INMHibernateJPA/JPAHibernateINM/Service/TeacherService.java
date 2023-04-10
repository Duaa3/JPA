package com.INMHibernateJPA.JPAHibernateINM.Service;

import com.INMHibernateJPA.JPAHibernateINM.Model.Teacher;
import com.INMHibernateJPA.JPAHibernateINM.Repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//indicates that this class is a Spring-managed service bean.
@Service
public class TeacherService {
    //perform CRUD operations on  teacher entities
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    public Teacher getATeacher(int id) {
        Optional<Teacher> foundRecord = teacherRepository.findById(id);
        return foundRecord.orElse(null);
    }

    public Teacher creatTeacher(Teacher currTeacher){
        return teacherRepository.save(currTeacher);
    }

    public Teacher uptdateTeacher(int id, Teacher upToDateTeacher){
        Teacher foundTeacher = getATeacher(id);
        if (foundTeacher != null) {
            foundTeacher.setName(upToDateTeacher.getName());
            foundTeacher.setEmail(upToDateTeacher.getEmail());
            return teacherRepository.save(foundTeacher);
        }
        return null;
    }

    public void deleteTeacher(int id){
        teacherRepository.deleteById(id);
    }

    private static final Logger logger = LoggerFactory.getLogger(TeacherService.class);

}

