package com.ss.lms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ss.lms.entity.Borrower;

@Component
public interface BorrowerDataAccess extends CrudRepository<Borrower, Integer>
{

}
