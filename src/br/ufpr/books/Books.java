/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.books;
import br.ufpr.people.Author;
import java.util.ArrayList;

/**
 *
 * @author ulisses
 */
public interface Books {
    
//    
//    public Books(){
//        this.isbn10 = "0000000000";
//        this.isbn13 = "000-0-00-000000-0";
//        this.name = "xxxxxxxxxxxxxxxx";
//        this.description = "xxxxxxxxxxxxxxxxxxx";
//    }
//    
//    public Books(Author author){
//        this.isbn10 = "0000000000";
//        this.isbn13 = "000-0-00-000000-0";
//        this.name = "xxxxxxxxxxxxxxxx";
//        this.description = "xxxxxxxxxxxxxxxxxxx";
//        this.author = author;
//    }
    
    public String showInfo();
    
    public boolean priceAdjustment (double adjustment);   
    
    public Books searchBook(String bookName, ArrayList<Books> books);    
    
    public String getName();
}
