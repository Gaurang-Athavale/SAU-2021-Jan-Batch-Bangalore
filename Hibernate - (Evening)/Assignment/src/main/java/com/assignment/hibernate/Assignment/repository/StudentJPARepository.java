package com.assignment.hibernate.Assignment.repository;

import com.assignment.hibernate.Assignment.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentJPARepository extends CrudRepository<Student, Integer> {

    public Student findStudentByExerciseId(int id);
}
