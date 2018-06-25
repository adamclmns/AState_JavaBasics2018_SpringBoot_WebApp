package com.adamclmns.javabasics.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adam
 * 
 * @ComponentScan tells SpringBoot to scan automatically for components. 
 */
@SpringBootApplication
public class BookServiceApplication {
    
    // This is our main class, where we call springboot
    public static void main(String args[]){
        // our "Application" class acts like a starting point for 
        // SpringBoot to scan and configure the rest of our components.
        SpringApplication.run(BookServiceApplication.class, args);
    }
}
