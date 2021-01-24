package com.assignment.hibernate.Assignment.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String yearOfStudy;

    @Column
    private Integer age;

    @Column
    private String BranchOfStudy;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Exercise exercise;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set <Department> department;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBranchOfStudy() {
        return BranchOfStudy;
    }

    public void setBranchOfStudy(String branchOfStudy) {
        BranchOfStudy = branchOfStudy;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Set<Department> getDepartment() {
        return department;
    }

    public void setDepartment(Set<Department> department) {
        this.department = department;
    }
}
