package com.ss.lms.entity;

import java.io.Serializable;

import javax.persistence.IdClass;

public class BookLoanCompositeKey implements Serializable
{
	private static final long serialVersionUID = 6330584754225219104L;

	private Integer bookId;
	private Integer branchId;
	private Integer cardNo;

	public BookLoanCompositeKey(){}

	public BookLoanCompositeKey(Integer cardNo, Integer branchId, Integer bookId)
	{
		super();
		this.bookId = bookId;
		this.branchId = branchId;
		this.cardNo = cardNo;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((branchId == null) ? 0 : branchId.hashCode());
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
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
		return true;
	}

	@Override
	public String toString()
	{
		return "BookLoanCompositeKey [bookId=" + bookId + ", branchId=" + branchId + ", cardNo=" + cardNo + "]";
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
}
