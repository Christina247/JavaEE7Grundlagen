package de.video2brain.javaee.jpa.beans;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sun.accessibility.internal.resources.accessibility;

import de.video2brain.javaee.jpa.entities.Author;
import de.video2brain.javaee.jpa.entities.Book;
import de.video2brain.javaee.jpa.entities.Contact;
import de.video2brain.javaee.jpa.entities.Publisher;

@Singleton
@Startup
public class BookManager {

	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	private void initialize() {
		
		BigInteger count = (BigInteger) 
				em.createNamedQuery("publisher_count").getSingleResult();
				
		if(count.intValue() == 0) {
			
			Publisher p = new Publisher("video2brain", "info@video2brain.com");

			Author a = new Author();
			a.setName("Karsten");
			a.setLastname("Samaschke");
			Contact aContact = new Contact();
			aContact.setEmail("karsten@samaschke.de");
			a.setContact(aContact);
			
			Book book = new Book();
			book.setTitle("Videotraining Java EE 7");
			book.setYear(2014);
			book.setIsbn("---");
			book.setPublisher(p);
			book.getAuthors().add(a);
			
			a.getBooks().add(book);
			p.getBooks().add(book);
			
			em.persist(p);
			
		}
	}
	
	public Book save(Book book) {
		em.persist(book);
		
		return book;
	}
	
	public List<Book> getBooks() {
		//Query query = 
		//		em.createQuery("SELECT b FROM Book b", Book.class);
		
		Query query =
				em.createNamedQuery("find_all_books", Book.class);
		
		return query.getResultList();
	}
	
	public Book getBook(int id) {
		return em.find(Book.class, id);
	}
	
	public Book updateBook(Book book) {
		em.merge(book);
		
		return book;
	}
	
	public void deleteBook(int id) {
		Book book = getBook(id);
		
		em.remove(book);
	}
	
	public void deleteBook(Book book) {
		em.remove(book);
	}
		
}
