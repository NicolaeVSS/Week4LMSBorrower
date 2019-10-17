package com.ss.lms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ss.lms.entity.Publisher;

@Component
public interface PublisherDataAccess extends CrudRepository<Publisher, Integer>
{

}
