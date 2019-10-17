package com.ss.lms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ss.lms.entity.LibraryBranch;

@Component
public interface LibraryBranchDataAccess extends CrudRepository<LibraryBranch, Integer>
{

}
