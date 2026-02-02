package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Type;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryStudents(studentDAO);
			//queryStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			//removeStudent(studentDAO);
			//removeAllStudents(studentDAO);

		};
	}

	private void removeAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students... ");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("deleted rows: " + numRowsDeleted);
	}

	private void removeStudent(StudentDAO studentDAO) {
		// remove the name
		studentDAO.removeById(5);

		System.out.println("Deleted successed !");
	}

	private void updateStudent(StudentDAO studentDAO) {
		// read the student
		Student myStudent = studentDAO.findById(1);
		// set the name
		myStudent.setFirstName("abdelrahman");
		// update
		studentDAO.update(myStudent);
		// display
		System.out.println(myStudent);
	}

	private void queryStudentByLastName(StudentDAO studentDAO) {
		// get list of students
		List<Student> theStudents = studentDAO.findByLastName("Ali");

		// display the students
		short y = 1;
		for (Student i : theStudents){
			System.out.println(y + "_-> " + i);
			y++;
		}
	}

	private void queryStudents(StudentDAO studentDAO) {
		// get list of students
		List<Student> tempstudents = studentDAO.findall();

		// display the students
		short y = 1;
		for (Student i : tempstudents){
			System.out.println(y + "_-> " + i);
			y++;
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student theStudent = studentDAO.findById(2);

		System.out.println(theStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		//create multi students
		System.out.println("create 4 student obj");
		Student tempStudent0 = new Student("Abdo", "Mohamed", "abdomo12320@gmail.com");
		Student tempStudent1 = new Student("maha", "mahmoud", "mahamo12320@gmail.com");
		Student tempStudent2 = new Student("ahmed", "Ali", "ahmedmo12320@gmail.com");
		Student tempStudent3 = new Student("mostafa", "Elsayed", "mostafamo12320@gmail.com");

		//save
		System.out.println("saving...");
		studentDAO.save(tempStudent0);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create student obj
		System.out.println("create new student obj");
		Student tempStudent = new Student("Abdo", "Mohamed", "abdomo12320@gmail.com");

		// save student obj
		System.out.println("saving...");
		studentDAO.save(tempStudent);

		// display id of saved student
		System.out.println("saved student ID : " + tempStudent.getId());

	}

}
