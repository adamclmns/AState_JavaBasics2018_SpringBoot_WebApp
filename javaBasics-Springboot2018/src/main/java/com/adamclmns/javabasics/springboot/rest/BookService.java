/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adamclmns.javabasics.springboot.rest;

import com.adamclmns.javabasics.springboot.data.BookRepository;
import com.adamclmns.javabasics.springboot.models.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Adam
 * @RestController tells SpringBoot that this class will handle HTTP Requests in a RESTful way
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
    
    @RequestMapping("")
    @ResponseBody
    public Iterable<Book> getAllBooks(){
        return bookRepo.findAll();
    }
    
}
