package com.INMHibernateJPA.JPAHibernateINM.Repository;

import com.INMHibernateJPA.JPAHibernateINM.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JPA interface for generic CRUD operations
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
