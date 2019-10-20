package com.ss.lms.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_book_loans")
public class BookLoan implements Serializable
{
	private static final long serialVersionUID = -3570078113098465234L;
	
	@EmbeddedId
	private BookLoanCompositeKey bookLoanKey;
	
	@Column(name = "dateOut")
	private Timestamp dateOut;
	
	@Column(name = "dueDate")
	private Timestamp dueDate;

	public BookLoan() {}

	public BookLoan(BookLoanCompositeKey bookLoanKey, Timestamp dateOut, Timestamp dueDate)
	{
		super();
		this.bookLoanKey = bookLoanKey;
		this.dateOut = dateOut;
		this.dueDate = dueDate;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookLoanKey == null) ? 0 : bookLoanKey.hashCode());
		result = prime * result + ((dateOut == null) ? 0 : dateOut.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
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
		BookLoan other = (BookLoan) obj;
		if (bookLoanKey == null)
		{
			if (other.bookLoanKey != null)
				return false;
		} else if (!bookLoanKey.equals(other.bookLoanKey))
			return false;
		if (dateOut == null)
		{
			if (other.dateOut != null)
				return false;
		} else if (!dateOut.equals(other.dateOut))
			return false;
		if (dueDate == null)
		{
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "BookLoan [bookLoanKey=" + bookLoanKey + ", dateOut=" + dateOut + ", dueDate=" + dueDate + "]";
	}

	public BookLoanCompositeKey getBookLoanKey()
	{
		return bookLoanKey;
	}

	public void setBookLoanKey(BookLoanCompositeKey bookLoanKey)
	{
		this.bookLoanKey = bookLoanKey;
	}

	public Timestamp getDateOut()
	{
		return dateOut;
	}

	public void setDateOut(Timestamp dateOut)
	{
		this.dateOut = dateOut;
	}

	public Timestamp getDueDate()
	{
		return dueDate;
	}

	public void setDueDate(Timestamp dueDate)
	{
		this.dueDate = dueDate;
	}
}
