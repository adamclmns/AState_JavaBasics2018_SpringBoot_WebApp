# Arkansas State University - Java Basics 2018
## Summer Java Boot Camp

This project contains source code used for the Summer 2018 Java Basics Online course offered by Arkansas State University.

## javaBasics-Springboot2018/
This is the WebApp Demo project in SpringBoot using H2 in-memory database, and SpringBoot CRUDRepositories. This is one of the simplest SpringBoot applications that can be written, but shows many concepts at work for Java Beginners.  

Students will start with a fully-functioning, if-not basic web application that manages books for a hypothetical library. Students will start by testing and mapping out existing behavior and functionality.

Students will be tasked with making modifications to the Application to add new features. They may also fix bugs, or improve existing features. This project is meant as a sandbox for students to start experimenting with Web Application concepts.

### Running the SpringBoot App

This SpringBoot app has a Maven Wrapper included. This allows you to run the project with just a command line and a JDK, even if you don't have Maven installed. 

```bat
cd javaBasics-Springboot2018
mvnw spring-boot:run -p 8080
```

When startup completes, you can navigate to [```http://localhost:8080/books```](http://localhost:8080/books) to start interacting with the application.

### Features in this Application

#### [GET] /books/
    Gets a list of all the books
#### [GET] /books/ping
    This is a ping test. Says "Hello!"
#### [GET] /books/count
    returns a count of books in the database
#### [GET] /books/author/{author}
    finds books by the author's name
#### [GET] /books/title/{title}
    finds books by the title
#### [GET] /books/search/{searchTerm}
    finds books by title or author, ignoring case and searching sub-strings
#### [GET] /books/published/{fromDate}/{toDate} 
    finds books published between {fromDate} and {toDate}


