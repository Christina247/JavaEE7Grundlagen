package de.video2brain.javaee.ejblite;

import java.util.List;
import javax.ejb.Remote;
import de.video2brain.javaee.entities.Book;

@Remote
public interface BookHandler {

	public abstract List<Book> getBooks();
	
}
