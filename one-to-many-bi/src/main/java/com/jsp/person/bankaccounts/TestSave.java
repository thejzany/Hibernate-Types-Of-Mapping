package com.jsp.person.bankaccounts;

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

		Person person = new Person();
		person.setName("Jay");
		person.setMail("jay@mail.com");

		BankAccount account1 = new BankAccount();
		account1.setBankname("IndianBank");
		account1.setAccno(12345678);

		BankAccount account2 = new BankAccount();
		account2.setBankname("Equitas");
		account2.setAccno(12345679);

		BankAccount account3 = new BankAccount();
		account3.setBankname("Equindian");
		account3.setAccno(12345670);

		List<BankAccount> accounts = new ArrayList<BankAccount>();
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);

		person.setAccounts(accounts);

		account1.setPerson(person);
		account2.setPerson(person);
		account3.setPerson(person);

		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();

	}

}
