/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.books;
import br.ufpr.people.Author;

/**
 *
 * @author ulisses
 */
public class Books {
    private String name;
    private String description;
    private double value;
    private String isbn13;
    private String isbn10;
    Author author = new Author();
    
    public Books(){
        this.isbn10 = "0000000000";
        this.isbn13 = "000-0-00-000000-0";
        this.name = "xxxxxxxxxxxxxxxx";
        this.description = "xxxxxxxxxxxxxxxxxxx";
    }
    
    public Books(Author author){
        this.isbn10 = "0000000000";
        this.isbn13 = "000-0-00-000000-0";
        this.name = "xxxxxxxxxxxxxxxx";
        this.description = "xxxxxxxxxxxxxxxxxxx";
        this.author = author;
    }
    
    public String showInfo(){
        return null;
    }
    
    public boolean priceAdjustment (double adjustment){
        if (adjustment <= 30){
            this.value += this.value * adjustment;
            return true;
        }  
        return false;
    }   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn) {
        this.isbn13 = isbn;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }
}
