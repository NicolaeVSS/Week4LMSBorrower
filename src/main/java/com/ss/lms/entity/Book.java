package com.ss.lms.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_book")
public class Book implements Serializable
{
	private static final long serialVersionUID = -712925798068921170L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookId", insertable = false, updatable = false, unique = true, nullable = false)
	private Integer bookId;
	
	@Column(name = "title")
	private String title;

	// MANY book authors exist, but only ONE can write a particular book
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "authId", nullable = false)
	private Author author;

	// MANY book publishers exist, but only ONE can publish a particular book
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pubId", nullable = false)
	private Publisher publisher;

	// ONE book may be loaned to MANY different borrowers
	@OneToMany(mappedBy = "bookLoanKey.book")
	private Collection<BookLoan> givenBooks;
	
	// ONE book may be owned by MANY different libraries
	@OneToMany(mappedBy = "bookCopyKey.book")
	private Collection<BookCopy> existingCopies;
	
	public Book() {}

	public Book(Integer bookId, String title, Author author, Publisher publisher)
	{
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null)
		{
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookId == null)
		{
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (publisher == null)
		{
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null)
		{
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", publisher=" + publisher + "]";
	}

	public Integer getBookId()
	{
		return bookId;
	}

	public void setBookId(Integer bookId)
	{
		this.bookId = bookId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Author getAuthor()
	{
		return author;
	}

	public void setAuthor(Author author)
	{
		this.author = author;
	}

	public Publisher getPublisher()
	{
		return publisher;
	}

	public void setPublisher(Publisher publisher)
	{
		this.publisher = publisher;
	}
}
