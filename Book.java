/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author frith
 */

import java.util.ArrayList;
import java.util.regex.Pattern;


/**
 * An dummy implementation of a book model, to 
 * demonstrate a JavaFX form.
 * 
 * @author anderslm@kth.se
 */
public class Book {
    
    public enum Genre { Crime, Mystery, Romance, Drama, Memoir, Fantasy,
    Learning}

    private String title;
    private String isbn; // check format
    private Genre genre;
    private String publisher;
    private ArrayList<Author> theAuthors;
    

    // A simplified regexp for isbn, 10 digit number, 
    // last digit may also be 'X' 
    private static final Pattern ISBN_PATTERN = 
            Pattern.compile("^\\d{12}[\\d|X]$"); 
    
    public static boolean isValidIsbn(String isbn) {
        return ISBN_PATTERN.matcher(isbn).matches();
        
    }
    
    public Book(String isbn, Genre genre, String title, String publisher,
            ArrayList<Author> authorsInput) {
        if(!isValidIsbn(isbn)) 
            throw new IllegalArgumentException("not a valid isbn");
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
        
        this.theAuthors = new ArrayList<Author>();
        //How do we add more authors when creating a book like during deSer?
        for (Author authors : authorsInput) {
                this.theAuthors.add(authors);
                  
        } 
    }
    
    public void setIsbn(String newISBN){ 
    
    }
    public void setGenre(Genre newGenre){ 
    
    }
    public void setTitle(String newTitle){
    
    }
    public void setPublisher(String newPublisher){ 
    
    }
    
    public String getIsbn()     { return isbn; }
    public String getTitle()    { return title; }
    public Genre getGenre()     { return genre; }
    public String getPublisher() { return publisher; }
    public ArrayList<Author> getAuthors() { return theAuthors; }
    
    @Override
    public String toString() {
        return "| " + isbn + "  | " + genre +"  | " + title + "   |  " 
                + publisher + "   |" + "   |   \n Author/s: " + theAuthors;
    }
}