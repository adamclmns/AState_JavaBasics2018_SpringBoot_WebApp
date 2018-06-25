/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adamclmns.javabasics.springboot.data;

import com.adamclmns.javabasics.springboot.models.Book;
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
    
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);

}
