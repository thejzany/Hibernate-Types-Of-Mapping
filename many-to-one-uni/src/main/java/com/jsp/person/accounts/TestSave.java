package com.jsp.person.accounts;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("thejzany");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Person person = new Person();
		person.setName("jay");
		person.setMail("jay@mail.com");
		person.setCno(9876543210l);
		person.setGender('M');
		
		
		BankAccount account1 = new BankAccount();
		account1.setBank_name("HDFC");
		account1.setAcc_no(816536536763l);
		account1.setIFSC_code("HDFC1236");
		account1.setPerson(person);
		
		BankAccount account2 = new BankAccount();
		account2.setBank_name("ICICI");
		account2.setAcc_no(916536536762l);
		account2.setIFSC_code("ICICI1235");
		account2.setPerson(person);
		
		BankAccount account3 = new BankAccount();
		account3.setBank_name("SBI");
		account3.setAcc_no(716536536761l);
		account3.setIFSC_code("SBI1234");
		account3.setPerson(person);
			
		
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		
		entityTransaction.begin();
		entityManager.persist(person);
		
		entityManager.persist(account1);
		entityManager.persist(account2);
		entityManager.persist(account3);
		entityTransaction.commit();
	
		
		
	}
}
