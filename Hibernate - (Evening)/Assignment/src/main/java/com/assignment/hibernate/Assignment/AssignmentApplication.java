package com.assignment.hibernate.Assignment;

import com.assignment.hibernate.Assignment.entity.Department;
import com.assignment.hibernate.Assignment.entity.Exercise;
import com.assignment.hibernate.Assignment.entity.Student;
import com.assignment.hibernate.Assignment.repository.StudentJPARepository;
import com.assignment.hibernate.Assignment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class AssignmentApplication implements CommandLineRunner {

	@Resource
	StudentRepository studentRepository;

	@Autowired
	StudentJPARepository studentJPARepository;

	public static void main(String[] args) {
		System.out.println("Hi");
		SpringApplication.run(AssignmentApplication.class, args);
	}

	@Override
	public void run(String args[]) throws Exception{
		Exercise exercise = new Exercise();
		Student student = new Student();
		Department department = new Department();

		// INSERT values(1)
		exercise.setDescription("Database Assignment");
		exercise.setDueDate(new Date(System.currentTimeMillis()));

		department.setHeadOfDept("Deepak Sharma");
		department.setName("Computer Engineering");

		Set<Department> departmentSet = new HashSet<Department>();
		departmentSet.add(department);

		exercise.setStudent(student);

		Set<Student> studentSet = new HashSet<Student>();
		studentSet.add(student);
		department.setStudent(studentSet);

		student.setName("Gaurang Athavale");
		student.setBranchOfStudy("Computer Engineering");
		student.setAge(21);
		student.setYearOfStudy("LY BTech.");
		student.setExercise(exercise);
		student.setDepartment(departmentSet);

//		studentRepository.addStudent(student);
//		studentJPARepository.save(student);

		// INSERT values(2)
		Exercise exercise1 = new Exercise();
		Student student1 = new Student();
		Department department1 = new Department();

		exercise1.setDescription("Operating Systems Assignment");
		exercise1.setDueDate(new Date(System.currentTimeMillis()));

		department1.setHeadOfDept("Manish Potey");
		department1.setName("Information Technology");

		Set<Department> departmentSet1 = new HashSet<Department>();
		departmentSet1.add(department1);

		exercise1.setStudent(student1);

		Set<Student> studentSet1 = new HashSet<Student>();
		studentSet.add(student1);
		department1.setStudent(studentSet1);

		student1.setName("Gaurav Bhagwanani");
		student1.setBranchOfStudy("Information Technology");
		student1.setAge(23);
		student1.setYearOfStudy("LY BTech.");
		student1.setExercise(exercise1);
		student1.setDepartment(departmentSet1);

//		studentRepository.addStudent(student1);
//		studentJPARepository.save(student1);


//		studentRepository.updateStudent(student);

//		studentRepository.deleteStudent(student);

		// FIND By EXERCISE ID
		Student student2 = studentJPARepository.findStudentByExerciseId(1);
		System.out.println("Name: "+student2.getName());
		System.out.println("Branch: "+student2.getBranchOfStudy());
		System.out.println("Year: "+student2.getYearOfStudy());
		System.out.println("Age: "+student2.getAge());

		// SELECT * FROM student
		List<Student> result = (List<Student>) studentJPARepository.findAll();
		for(Student s: result){
			System.out.println("Name: "+s.getName());
			System.out.println("Branch: "+s.getBranchOfStudy());
			System.out.println("Year: "+s.getYearOfStudy());
			System.out.println("Age: "+s.getAge()+"\n");
		}
	}

}
