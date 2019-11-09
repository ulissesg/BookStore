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
       
    public String showInfo();
    
    public boolean priceAdjustment (double adjustment);   
    
    public Books searchBook(String bookName, ArrayList<Books> books);    
    
    public String getName();
}
