package com.cafe4code.crud;
import com.cafe4code.crud.dao.AppDAO;
import com.cafe4code.crud.entity.Instructor;
import com.cafe4code.crud.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(AppDAO appDAO){
		return runner ->{
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//createInstructors(appDAO);
			//findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("delete instructor' detail of id: ");
		int id = scanner.nextInt();

		appDAO.deleteDetail(id);
		System.out.println("Done deleting!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id of instructor details: ");
		int id = scanner.nextInt();

		InstructorDetail detail = appDAO.findInstructorDetailById(id);

		System.out.println("-------------------------------------");
		System.out.println("the instructor details are: " + detail);
		System.out.println("-------------------------------------");
		System.out.println("the instructor is: " + detail.getInstructor());

	}

	private void createInstructors(AppDAO appDAO) {

		Object[][] data = {
				{"ahmed",  "hassan",  "ahmed@cafe4code.com",  "ahmed.h@cafe4code.com",  "football"},
				{"mona",   "ibrahim", "mona@cafe4code.com",   "mona.i@cafe4code.com",   "reading"},
				{"omar",   "saleh",   "omar@cafe4code.com",   "omar.s@cafe4code.com",   "swimming"},
				{"sara",   "adel",    "sara@cafe4code.com",   "sara.a@cafe4code.com",   "yoga"},
				{"khaled", "mostafa", "khaled@cafe4code.com", "khaled.m@cafe4code.com", "gym"}
		};

		for (Object[] row : data){
			Instructor instructor = new Instructor((String)row[0], (String)row[1], (String)row[2]);
			instructor.setInstructorDetail(new InstructorDetail((String)row[3], (String)row[4]));

			appDAO.save(instructor);
		}
		System.out.println("Done Saving!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("delete instructor of id: ");

		int id = scanner.nextInt();
		appDAO.delete(id);
		System.out.println("Done deleting!");
	}

	private void findInstructor(AppDAO appDAO) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id of instructor: ");

		int id = scanner.nextInt();
		System.out.println("-------------------------------------");
		System.out.println("the instructor is: " + appDAO.findById(id));
		System.out.println("-------------------------------------");

	}

	private void createInstructor(AppDAO appDAO) {

		Instructor instructor = new Instructor("noha", "ali", "noha@cafe4code.com");
		InstructorDetail detail = new InstructorDetail("abdo@cafe4code.com", "tennis");

		instructor.setInstructorDetail(detail);

		System.out.println("Saving instructor: " + instructor);

		appDAO.save(instructor);
		System.out.println("Done Saving!");
	}
}
