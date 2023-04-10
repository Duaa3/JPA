package com.INMHibernateJPA.JPAHibernateINM.Repository;

import com.INMHibernateJPA.JPAHibernateINM.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
//JPA interface for generic CRUD operations
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
