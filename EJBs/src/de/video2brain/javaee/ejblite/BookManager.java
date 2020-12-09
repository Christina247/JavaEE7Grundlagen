package de.video2brain.javaee.ejblite;

import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.video2brain.javaee.entities.Book;

@Stateless @LocalBean
public class BookManager implements BookHandler {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Gibt eine Liste von Büchern zurück
	 */
	public List<Book> getBooks() {
		return em.createNamedQuery("all_books", Book.class).getResultList();
	}
	
	/**
	 * Speichert ein Buch
	 */
	public void saveBook(Book book) {
		em.persist(book);
	}
}
