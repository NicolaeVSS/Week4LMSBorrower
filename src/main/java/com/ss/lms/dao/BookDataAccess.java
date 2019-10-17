/**
 * 
 */
package com.ss.lms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ss.lms.entity.Book;

@Component
public interface BookDataAccess extends CrudRepository<Book, Integer>
{

}
