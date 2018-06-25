/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adamclmns.javabasics.springboot.models;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Adam
 */
@Entity
public class Book {
    @Id
    private UUID id;
    
    private String title;
    private String author;
    private Date published;
    private Date lastBorrowed;
    private Date lastReturned;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public Date getLastBorrowed() {
        return lastBorrowed;
    }

    public void setLastBorrowed(Date lastBorrowed) {
        this.lastBorrowed = lastBorrowed;
    }

    public Date getLastReturned() {
        return lastReturned;
    }

    public void setLastReturned(Date lastReturned) {
        this.lastReturned = lastReturned;
    }
    
    
    public boolean equals(Book book){
        return this.id == book.id;
    }
}
