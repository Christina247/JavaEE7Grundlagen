package de.video2brain.javaee.ejblite;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.video2brain.javaee.ejb.interceptor.Logging;
import de.video2brain.javaee.entities.Book;

@Singleton
@Startup
@Logging
public class Initializer {

	@PersistenceContext
	private EntityManager em;
	
	@EJB
	private BookManager bookManager;
	
	@PostConstruct
	private void initialize() {
		
		System.out.println("==> INITALISIERE DATEN");
		
		int currentCount = bookManager.getBooks().size();
		
		if(currentCount < 100) {
			Book newBook = new Book();
			newBook.setTitle("Buch #" + (currentCount + 1));
			newBook.setIsbn("---");
			newBook.setYear(2014 - new Random().nextInt(100));
			
			bookManager.saveBook(newBook);
		}
		
	}
	
}
