/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adamclmns.javabasics.springboot.rest;

import com.adamclmns.javabasics.springboot.data.BookRepository;
import com.adamclmns.javabasics.springboot.models.Book;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Adam
 * @RestController tells SpringBoot that this class will handle HTTP Requests in a RESTful way
 * @RequestMapping - when applied to a class, this sets a "base" path for the rest of the methods. 
 *      All paths will start with /books 
 */
@RestController
@RequestMapping("books")
public class BookService {
    
    @Autowired
    BookRepository bookRepo;
    
    /*
    @Request Mapping sets the path this method will listen on
    @ResponseBody means that the return value will be converted into a Response Body. Even if it's a complex Object.
    */
    @RequestMapping("ping")
    @ResponseBody
    public String getPing(){
        return "Hello from Book Service!";
    }
    
    @RequestMapping("")// This one will just be /books/
    @ResponseBody
    public Iterable<Book> getAllBooks(){
        return bookRepo.findAll();
    }
    
    @RequestMapping("count")
    @ResponseBody
    public int countBooks(){
        return ((List<Book>)bookRepo.findAll()).size();
    }
    
    @RequestMapping("title/{title}")
    @ResponseBody
    public List<Book> findBookByTitle(@PathVariable("title") String title){
        return bookRepo.findByTitleContainingIgnoreCase(title);
    }
    
    @RequestMapping("author/{author}")
    @ResponseBody
    public List<Book> findBookByAuthor(@PathVariable("author") String author){
        return bookRepo.findByAuthorContainingIgnoreCase(author);
    }
    
    // Here we are using several SpringBoot annotations to specify DateTime formatting and multiple Path Variables. 
    // More about Java Date Formatting Syntax and Patterns 
    //      - http://tutorials.jenkov.com/java-internationalization/simpledateformat.html
    @RequestMapping("published/{fromDate}/{toDate}")
    @ResponseBody
    public List<Book> findBookByPublishDateRange(
            @PathVariable("fromDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate, 
            @PathVariable("toDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate){
        return bookRepo.findByPublishedGreaterThanEqualAndPublishedLessThanEqual(fromDate, toDate);
    }
    
    // Because CRUD Repositories require us to use two parameters when searching two fields, 
    // We've just used the same variable to satisfy both arguments. So we can search both fields for the same value
    @RequestMapping("search/{searchTerm}")
    @ResponseBody
    public List<Book> searchByTitleAuthorString(@PathVariable("searchTerm") String searchTerm){
        return bookRepo.findByTitleContainsIgnoreCaseOrAuthorContainsIgnoreCase(searchTerm, searchTerm);
    }
    
}
