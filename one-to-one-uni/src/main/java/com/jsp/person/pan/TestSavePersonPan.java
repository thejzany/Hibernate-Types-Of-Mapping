package com.jsp.person.pan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonPan {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("thejzany");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person = new Person();

		// create person object
		person.setName("jay");
		person.setEmail("jay@mail.com");
		person.setCno(1234567890l);

		Pan pan = new Pan();
		pan.setAddress("Mumbai");

		// setting pan of specified person
		pan.setPerson(person);

		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(pan);
		entityTransaction.commit();

	}

}
