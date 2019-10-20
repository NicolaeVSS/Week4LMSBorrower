package com.ss.lms.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_book_copies")
public class BookCopy implements Serializable 
{
    private static final long serialVersionUID = -7441409147455698231L;

    @EmbeddedId
    private BookCopyCompositeKey bookCopyKey;
    
    @Column(name = "noOfCopies")
	private Integer noOfCopies;
    
    public BookCopy() {}

	public BookCopy(BookCopyCompositeKey bookCopyKey, Integer noOfCopies)
	{
		super();
		this.bookCopyKey = bookCopyKey;
		this.noOfCopies = noOfCopies;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookCopyKey == null) ? 0 : bookCopyKey.hashCode());
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
		if (bookCopyKey == null)
		{
			if (other.bookCopyKey != null)
				return false;
		} else if (!bookCopyKey.equals(other.bookCopyKey))
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
		return "BookCopy [bookCopyKey=" + bookCopyKey + ", noOfCopies=" + noOfCopies + "]";
	}

	public BookCopyCompositeKey getBookCopyKey()
	{
		return bookCopyKey;
	}

	public void setBookCopyKey(BookCopyCompositeKey bookCopyKey)
	{
		this.bookCopyKey = bookCopyKey;
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
