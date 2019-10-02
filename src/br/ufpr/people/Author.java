/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.people;

import java.util.ArrayList;

/**
 *
 * @author ulisses
 */
public class Author extends People{
    private double ID;
    
    public Author() {
        this.setID(0000000000000);
        this.setPeapleName("xxxxxxxxxxxxxx");
        this.setPeapleEmail("example@gmail.com");
        this.setPeapleCpf("xxx.xxx.xxx-xx");
    }
    
    public String showAuthorInfo(){
        return("\n--------------------------------------------------------\n"
                + "Author ID: " + this.getID() + "\n"
                + "Author Name: " + this.getPeapleName() + "\n"
                + "Author Email: " + this.getPeapleEmail() + "\n"
                + "Author CPF: " + this.getPeapleCpf()
                + "\n-------------------------------------------------------");       
    }
    
     public boolean verifyAuthor (){
        if (this.getPeapleName() == null && this.getPeapleEmail() == null 
                && this.getPeapleCpf() == null){
            return false;
        }
        return true;
    }
     
    public Author searchAuthor(double id, ArrayList<Author> authors){
        for(Author author: authors){
            double x = author.getID();
            if (x == id){
                return author;
            }
        }
        return null;
    }

    public double getID() {
        return ID;
    }

    public void setID(double ID) {
        this.ID = ID;
    }
}
