/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adamclmns.javabasics.springboot.data;

import com.adamclmns.javabasics.springboot.models.Book;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adam
 * SpringFramework Magic to be explained later is happening here.
 */
@Service
public interface BookRepository extends CrudRepository<Book,UUID>{
    // This method stacsk a lot of keywords to force certain Query behavior.
    // "Containing" tells SpringBoot that we want to search by *part* of the title, not the whole thing.
    // "IngoreCase" tells SpringBoot that it should ignore upper/lower case. ie - "Wind" vs "wind" vs "WIND"
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByAuthorContainingIgnoreCase(String author);
    
    // Here we use some more SpringBoot JPA/CRUD Repository magic
    List<Book> findAllByPublishedGreaterThanEqualAndPublishedLessThanEqual(Date fromDate, Date toDate);
}
