package com.ss.lms.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ss.lms.entity.BookLoan;
import com.ss.lms.entity.BookLoanCompositeKey;


@Component
public interface BookLoanDataAccess extends CrudRepository<BookLoan, BookLoanCompositeKey> {

}
