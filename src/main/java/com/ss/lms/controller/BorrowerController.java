package com.ss.lms.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.lms.entity.Book;
import com.ss.lms.entity.BookCopy;
import com.ss.lms.entity.BookCopyCompositeKey;
import com.ss.lms.entity.BookLoan;
import com.ss.lms.entity.BookLoanCompositeKey;
import com.ss.lms.entity.Borrower;
import com.ss.lms.entity.LibraryBranch;
import com.ss.lms.service.BorrowerService;

@RestController
@RequestMapping(value = "/lms/borrower")
public class BorrowerController {

	@Autowired
	BorrowerService borrow;
	
	@PostMapping(path = "/bookloan",  produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
					consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<BookLoan> createBookLoan(@RequestBody BookLoan bookloan){
		
		Timestamp timestamp = new Timestamp(new Date().getTime());
		Calendar duetime = Calendar.getInstance();
		
		if(bookloan.getBookLoanKey() == null || bookloan.getDateOut() != null || bookloan.getDueDate() != null) {
			return new ResponseEntity<BookLoan>(HttpStatus.BAD_REQUEST);
		}
		bookloan.setDateOut(timestamp);
		duetime.add(Calendar.DAY_OF_MONTH, 7);
		timestamp = new Timestamp(duetime.getTime().getTime());
		bookloan.setDueDate(timestamp);
		
		
		
		Optional<Borrower> foundBorrower = borrow.readBorrowerById(bookloan.getBookLoanKey().getBorrower().getCardNo());
		if(!foundBorrower.isPresent()) {
			return new ResponseEntity<BookLoan>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		Optional<LibraryBranch> foundBranch = borrow.readLibraryBranchById(bookloan.getBookLoanKey().getBranch().getBranchId());
		
		if(!foundBranch.isPresent()) {
			return new ResponseEntity<BookLoan>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		Optional<Book> foundBook = borrow.readBookById(bookloan.getBookLoanKey().getBook().getBookId());
		
		if(!foundBook.isPresent()) {
			return new ResponseEntity<BookLoan>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		BookLoanCompositeKey loanKey =  new BookLoanCompositeKey(foundBook.get(),foundBranch.get(), 
						foundBorrower.get());
	
		if(borrow.readBookLoanById(loanKey).isPresent()){
			return new ResponseEntity<BookLoan>(HttpStatus.NOT_FOUND);
		}
		
		BookCopyCompositeKey bookCopyCompositeKey = new BookCopyCompositeKey(loanKey.getBook(),loanKey.getBranch());
		
		if(!borrow.readBookCopyByBranchId(bookCopyCompositeKey).isPresent()) {
			return new ResponseEntity<BookLoan>(HttpStatus.NOT_FOUND);
		}
				
		int numOfCopies = borrow.readBookCopyByBranchId(bookCopyCompositeKey).get().getNoOfCopies();
		
		if(numOfCopies < 1) {
			return new ResponseEntity<BookLoan>(HttpStatus.NOT_FOUND);
		}
			
		BookCopy bookCopy = new BookCopy( bookCopyCompositeKey,numOfCopies - 1);
		borrow.saveBookCopy(bookCopy);
		
		return new ResponseEntity<BookLoan>(borrow.saveBookLoan(bookloan),HttpStatus.CREATED);
			
	}
	
	
	
	
	@DeleteMapping(value = "/bookloan/{cardNo}/branch/{branchId}/bookId/{bookId}")
	public ResponseEntity<HttpStatus> deleteBookLoan(@PathVariable Integer cardNo, @PathVariable Integer branchId,@PathVariable Integer bookId)
	{
		Optional<Borrower> foundBorrower = borrow.readBorrowerById(cardNo);
		if(!foundBorrower.isPresent()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		
		Optional<LibraryBranch> foundBranch = borrow.readLibraryBranchById(branchId);
		
		if(!foundBranch.isPresent()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		
		Optional<Book> foundBook = borrow.readBookById(bookId);
		
		if(!foundBook.isPresent()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		
		BookLoanCompositeKey loanKey =  new BookLoanCompositeKey(foundBook.get(),foundBranch.get(), 
						foundBorrower.get());
		if(!borrow.readBookLoanById(loanKey).isPresent()){
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		
		BookCopyCompositeKey bookCopyCompositeKey = new BookCopyCompositeKey(loanKey.getBook(),loanKey.getBranch());
		
		if(!borrow.readBookCopyByBranchId(bookCopyCompositeKey).isPresent()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		
		int numOfCopies = borrow.readBookCopyByBranchId(bookCopyCompositeKey).get().getNoOfCopies();
		
		BookCopy bookCopy = new BookCopy( bookCopyCompositeKey,numOfCopies + 1);
		borrow.saveBookCopy(bookCopy);
		
		borrow.deleteBookloan(loanKey);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	@GetMapping(value = "/bookloan/{cardNo}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Iterable<BookLoan>> readBookLoanByAllId(@PathVariable("cardNo") Integer cardNo)
	{
		
		Iterable<BookLoan> result = borrow.readAllBookLoan();
		
		List<BookLoan> filteredList = new ArrayList<BookLoan>();
		
		result.forEach(ele -> 
		{
			if(ele.getBookLoanKey().getBorrower().getCardNo() == cardNo) 
			{
				filteredList.add(ele);
			}
		});
		
		if(!filteredList.iterator().hasNext()) 
		{ 
			return new ResponseEntity<Iterable<BookLoan>>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<Iterable<BookLoan>>(filteredList, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/branch", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Iterable<LibraryBranch>> readAllLibraryBranch()
	{
		Iterable<LibraryBranch> result = borrow.readAllLibraryBranch();
		// 200 regardless of if we found it or not, the query was successful, it means they can keep doing it
		if(!result.iterator().hasNext()) 
		{
			return new ResponseEntity<Iterable<LibraryBranch>>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Iterable<LibraryBranch>>(result, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/bookcopy/{branchId}",  produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Iterable<BookCopy>> readAllBookCopies(@PathVariable Integer branchId){
	
		Iterable<BookCopy> result = borrow.readAllCopy();
		
		List<BookCopy> filteredList = new ArrayList<BookCopy>();
		
		result.forEach(ele -> 
		{
			if(ele.getNoOfCopies() > 0) 
			{
				if(ele.getBookCopyKey().getBranch().getBranchId() == branchId)
				filteredList.add(ele);
			}
		});
		
		if(!filteredList.iterator().hasNext()) 
		{
			return new ResponseEntity<Iterable<BookCopy>>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<Iterable<BookCopy>>(filteredList, HttpStatus.OK);
		}
	}
		
	

	
}
