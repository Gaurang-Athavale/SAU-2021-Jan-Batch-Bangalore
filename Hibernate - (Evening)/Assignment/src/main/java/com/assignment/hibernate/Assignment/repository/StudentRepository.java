package com.assignment.hibernate.Assignment.repository;

import com.assignment.hibernate.Assignment.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    @PersistenceContext
    EntityManager entityManager;

    // CREATE
    public void addStudent(Student student){
        entityManager.persist(student);
    }

    // DELETE
    public void deleteStudent(Student student){
        entityManager.remove(student);
    }

    // UPDATE
    public Student updateStudent(Student student){
        return entityManager.merge(student);
    }

    // RETRIEVE
    public Student getStudentById(int id){
        return entityManager.find(Student.class, id);
    }
}
