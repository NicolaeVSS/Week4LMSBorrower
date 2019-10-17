package com.ss.lms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ss.lms.entity.Author;

@Component
public interface AuthorDataAccess extends CrudRepository<Author, Integer>
{
	
}
