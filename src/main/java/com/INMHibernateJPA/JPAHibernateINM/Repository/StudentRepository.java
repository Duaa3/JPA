package com.INMHibernateJPA.JPAHibernateINM.Repository;

import com.INMHibernateJPA.JPAHibernateINM.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
//JPA interface for generic CRUD operations
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
