package de.video2brain.javaee.jpa.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import de.video2brain.javaee.jpa.beans.BookManager;
import de.video2brain.javaee.jpa.entities.Book;

@Named
@ApplicationScoped
public class BookHandler {
	
	@Inject
	private Book toBeSaved;
	
    @EJB
    private BookManager manager;
	
	public void createBook(ActionEvent event) {
		// To be done
		manager.save(toBeSaved.cloneBook());
	}
	
	public List<Book> getBooks() {
		return manager.getBooks();
	}
	
	public void delete(int id) {
		manager.deleteBook(id);
	}

	public void update(int id) {
		Book book = manager.getBook(id);
		
		int newYear = 0;
		while(newYear < 1900 || newYear == book.getYear()) {
			newYear = new Random().nextInt(2020);
		}
		
		book.setYear(newYear);
		manager.updateBook(book);
	}
	
}

