package com.ss.lms.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class BookCopyCompositeKey implements Serializable
{
	private static final long serialVersionUID = 3189581310335082008L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bookId", nullable = false)
	private Book book;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "branchId", nullable = false)
	private LibraryBranch branch;

	public BookCopyCompositeKey() {}
	
	public BookCopyCompositeKey(Book book, LibraryBranch branch)
	{
		super();
		this.book = book;
		this.branch = branch;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
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
		BookCopyCompositeKey other = (BookCopyCompositeKey) obj;
		if (book == null)
		{
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (branch == null)
		{
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "BookCopyCompositeKey [book=" + book + ", branch=" + branch + "]";
	}

	public Book getBook()
	{
		return book;
	}

	public void setBook(Book book)
	{
		this.book = book;
	}

	public LibraryBranch getBranch()
	{
		return branch;
	}

	public void setBranch(LibraryBranch branch)
	{
		this.branch = branch;
	}
}
