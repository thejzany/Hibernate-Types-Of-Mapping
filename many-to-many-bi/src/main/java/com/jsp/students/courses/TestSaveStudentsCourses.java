package com.jsp.students.courses;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudentsCourses {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("thejzany");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student1 = new Student();
		student1.setName("Jay");
		student1.setMail("jay@mail.com");

		Student student2 = new Student();
		student2.setName("Mansi");
		student2.setMail("mansi@mail.com");

		Student student3 = new Student();
		student3.setName("Sia");
		student3.setMail("sia@mail.com");

		Course course1 = new Course();
		course1.setCoursename("Java");
		course1.setDuration("2months");

		Course course2 = new Course();
		course2.setCoursename("Web Technologies");
		course2.setDuration("1months");

		Course course3 = new Course();
		course3.setCoursename("Advanced Java");
		course3.setDuration("2months");

		List<Student> students = new ArrayList<Student>();		
		students.add(student1);
		students.add(student2);
		students.add(student3);

		List<Course> courses = new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);

		student1.setCourses(courses);
		student2.setCourses(courses);
		student3.setCourses(courses);

		course1.setStudents(students);
		course2.setStudents(students);
		course3.setStudents(students);

		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);
		entityTransaction.commit();
	}
}
