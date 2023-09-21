package com.jsp.bank.branches;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("thejzany");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		Bank bank = new Bank();
		bank.setName("IndianBank");

		Branch b1 = new Branch();
		b1.setAddress("TilakNagar");

		Branch b2 = new Branch();
		b2.setAddress("MG Road");

		Branch b3 = new Branch();
		b3.setAddress("Chembur");

		List<Branch> branches = new ArrayList<Branch>();
		branches.add(b1);
		branches.add(b2);
		branches.add(b3);
		
		bank.setBranches(branches);
		
		b1.setBank(bank);
		b2.setBank(bank);
		b3.setBank(bank);
		
		entityTransaction.begin();
		entityManager.persist(bank);
		entityManager.persist(b1);
		entityManager.persist(b2);
		entityManager.persist(b3);
		entityTransaction.commit();
		

	}
}
