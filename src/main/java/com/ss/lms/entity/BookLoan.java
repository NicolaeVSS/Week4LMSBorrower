package com.ss.lms.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_book_loans")
@IdClass(BookLoanCompositeKey.class)
public class BookLoan implements Serializable
{
	private static final long serialVersionUID = -3570078113098465234L;
	
	@Id
	private Integer bookId;
	@Id
	private Integer branchId;
	@Id
	private Integer cardNo;
	private Timestamp dateOut;
	private Timestamp dueDate;

	public BookLoan() {}
	
	public BookLoan(Integer bookId, Integer branchId, Integer cardNo, Timestamp dateOut, Timestamp dueDate)
	{
		this.bookId = bookId;
		this.branchId = branchId;
		this.cardNo = cardNo;
		this.dateOut = dateOut;
		this.dueDate = dueDate;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((branchId == null) ? 0 : branchId.hashCode());
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
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
		if (cardNo == null)
		{
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
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
		return "BookLoan [bookId=" + bookId + ", branchId=" + branchId + ", cardNo=" + cardNo + ", dateOut=" + dateOut
				+ ", dueDate=" + dueDate + "]";
	}

	public Integer getBookId()
	{
		return bookId;
	}

	public void setBookId(Integer bookId)
	{
		this.bookId = bookId;
	}

	public Integer getBranchId()
	{
		return branchId;
	}

	public void setBranchId(Integer branchId)
	{
		this.branchId = branchId;
	}

	public Integer getCardNo()
	{
		return cardNo;
	}

	public void setCardNo(Integer cardNo)
	{
		this.cardNo = cardNo;
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
