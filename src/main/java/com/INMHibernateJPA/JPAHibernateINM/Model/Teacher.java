package com.INMHibernateJPA.JPAHibernateINM.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
//database table name
@Table(name = "pro_teacher")
public class Teacher {
    //indicating that this field serves as the primary key of the database table.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column
    public String name;
    @Column
    //used to validate that the email field conforms to a regular expression pattern
    @Pattern(regexp="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", message="Invalid email")
    public String email;
    public Teacher() {
    }

    public Teacher(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


