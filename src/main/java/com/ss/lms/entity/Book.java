package com.ss.lms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_book")
public class Book implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Integer bookId;
	private String title;
	private Integer authId; 
	private Integer pubId; 

	public Book() {}

	public Book(String title, Integer authorId, Integer publisherId)
	{
		this.title = title;
		this.authId = authorId;
		this.pubId = publisherId;
	}
	
	public Book(Integer bookId, String title, Integer authorId, Integer publisherId)
	{
		this.bookId = bookId;
		this.title = title;
		this.authId = authorId;
		this.pubId = publisherId;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authId == null) ? 0 : authId.hashCode());
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((pubId == null) ? 0 : pubId.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Book other = (Book) obj;
		if (authId == null)
		{
			if (other.authId != null)
			{
				return false;
			}
		} else if (!authId.equals(other.authId))
		{
			return false;
		}
		if (bookId == null)
		{
			if (other.bookId != null)
			{
				return false;
			}
		} else if (!bookId.equals(other.bookId))
		{
			return false;
		}
		if (pubId == null)
		{
			if (other.pubId != null)
			{
				return false;
			}
		} else if (!pubId.equals(other.pubId))
		{
			return false;
		}
		if (title == null)
		{
			if (other.title != null)
			{
				return false;
			}
		} else if (!title.equals(other.title))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "Book [bookId=" + bookId + ", title=" + title + ", authorId=" + authId + ", publisherId=" + pubId
				+ "]";
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

	public Integer getAuthorId()
	{
		return authId;
	}

	public void setAuthorId(Integer authorId)
	{
		this.authId = authorId;
	}

	public Integer getPublisherId()
	{
		return pubId;
	}

	public void setPublisherId(Integer publisherId)
	{
		this.pubId = publisherId;
	}
	
	
}
