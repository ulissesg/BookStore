/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.books;

import java.util.ArrayList;

/**
 *
 * @author ulisses
 */
public class SearchBook implements Books{

    @Override
    public String showInfo() {
        return null;
    }

    @Override
    public boolean priceAdjustment(double adjustment) {
        return false;
    }

    @Override
    public Books searchBook(String bookName, ArrayList<Books> books) {
        for (Books pBs : books){
            if (pBs.getName().equalsIgnoreCase(bookName)){
                return pBs;
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
    
}
