package de.video2brain.javaee.jpa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

@Named("toBeSaved")
@RequestScoped
@Entity
@Table(name = "books")

@NamedNativeQueries({
	@NamedNativeQuery(name = "publisher_count",
			query = "SELECT COUNT(1) FROM publishers")	
})

@NamedQueries({
	@NamedQuery(name = "find_book",
			query = "SELECT b FROM Book b WHERE b.id = :id"),
	@NamedQuery(name = "find_all_books",
			query = "SELECT b FROM Book b")
})
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String isbn;
	
	private int year = 1900;
	
	@Version
	private int version;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "publisher")
	private Publisher publisher;
	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
	@JoinTable(
			name = "authors_books",
			joinColumns = { @JoinColumn(name = "book", referencedColumnName = "id") },
			inverseJoinColumns = { @JoinColumn(name = "author", referencedColumnName = "id")})
	private List<Author> authors;

	public Book() {
		authors = new ArrayList<Author>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Book cloneBook() {
		Book result = new Book();
		result.setId(getId());
		result.setYear(getYear());
		result.setTitle(getTitle());
		result.setIsbn(getIsbn());
		result.setPublisher(getPublisher());
		result.setAuthors(getAuthors());
				
		return result;
	}
	
}
