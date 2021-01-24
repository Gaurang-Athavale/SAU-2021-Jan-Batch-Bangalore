package com.assignment.hibernate.Assignment.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String headOfDept;

    @ManyToMany()
    Set<Student> student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadOfDept() {
        return headOfDept;
    }

    public void setHeadOfDept(String headOfDept) {
        this.headOfDept = headOfDept;
    }

    public Set<Student> getStudent() {
        return student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
    }
}
