package com.ss.lms.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_book_copies")
@IdClass(BookCopyCompositeKey.class)
public class BookCopy implements Serializable
{
	private static final long serialVersionUID = -7441409147455698231L;

	@Id
	private Integer bookId;
	@Id
	private Integer branchId;
	private Integer noOfCopies;

	public BookCopy(){}

	public BookCopy(Integer bookId, Integer branchId, Integer noOfCopies)
	{
		this.bookId = bookId;
		this.branchId = branchId;
		this.noOfCopies = noOfCopies;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((branchId == null) ? 0 : branchId.hashCode());
		result = prime * result + ((noOfCopies == null) ? 0 : noOfCopies.hashCode());
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
		BookCopy other = (BookCopy) obj;
		if (bookId == null)
		{
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (branchId == null)
		{
			if (other.branchId != null)
				return false;
		} else if (!branchId.equals(other.branchId))
			return false;
		if (noOfCopies == null)
		{
			if (other.noOfCopies != null)
				return false;
		} else if (!noOfCopies.equals(other.noOfCopies))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "BookCopy [bookid=" + bookId + ", branchId=" + branchId + ", noOfCopies=" + noOfCopies + "]";
	}

	public Integer getBookid()
	{
		return bookId;
	}

	public void setBookid(Integer bookid)
	{
		this.bookId = bookid;
	}

	public Integer getBranchId()
	{
		return branchId;
	}

	public void setBranchId(Integer branchId)
	{
		this.branchId = branchId;
	}

	public Integer getNoOfCopies()
	{
		return noOfCopies;
	}

	public void setNoOfCopies(Integer noOfCopies)
	{
		this.noOfCopies = noOfCopies;
	}
}
