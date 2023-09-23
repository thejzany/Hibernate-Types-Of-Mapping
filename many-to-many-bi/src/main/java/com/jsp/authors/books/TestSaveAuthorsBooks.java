package com.jsp.authors.books;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveAuthorsBooks {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("thejzany");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		Author author1 = new Author();
		author1.setName("Larry Niven");
		author1.setAge(85);

		Author author2 = new Author();
		author2.setName("Jerry Pournelle");
		author2.setAge(84);

		Book book1 = new Book();
		book1.setBookName("Lucifer's Hammer");
		book1.setGenre("Novel");

		Book book2 = new Book();
		book2.setBookName("The Mote in God's Eye");
		book2.setGenre("Novel");

		Book book3 = new Book();
		book3.setBookName("Oath of Fealty");
		book3.setGenre("Novel");

		List<Author> authors = new ArrayList<Author>();
		authors.add(author1);
		authors.add(author2);

		List<Book> books = new ArrayList<Book>();
		books.add(book1);
		books.add(book2);
		books.add(book3);

		author1.setBooks(books);
		author2.setBooks(books);

		book1.setAuthors(authors);
		book2.setAuthors(authors);
		book3.setAuthors(authors);

		entityTransaction.begin();
		entityManager.persist(book1);
		entityManager.persist(book2);
		entityManager.persist(book3);
		entityTransaction.commit();

	}
}
