package com.ss.lms.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class BookLoanCompositeKey implements Serializable
{
	private static final long serialVersionUID = 6330584754225219104L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bookId", nullable = false)
	private Book book;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "branchId", nullable = false)
	private LibraryBranch branch;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cardNo", nullable = false)
	private Borrower borrower;

	public BookLoanCompositeKey() {}
	
	public BookLoanCompositeKey(Book book, LibraryBranch branch, Borrower borrower)
	{
		super();
		this.book = book;
		this.branch = branch;
		this.borrower = borrower;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((borrower == null) ? 0 : borrower.hashCode());
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
		BookLoanCompositeKey other = (BookLoanCompositeKey) obj;
		if (book == null)
		{
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (borrower == null)
		{
			if (other.borrower != null)
				return false;
		} else if (!borrower.equals(other.borrower))
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
		return "BookLoanCompositeKey [book=" + book + ", branch=" + branch + ", borrower=" + borrower + "]";
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

	public Borrower getBorrower()
	{
		return borrower;
	}

	public void setBorrower(Borrower borrower)
	{
		this.borrower = borrower;
	}
}
