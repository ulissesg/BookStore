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
        this.setPeopleName("xxxxxxxxxxxxxx");
        this.setPeopleEmail("example@gmail.com");
        this.setPeopleCpf("xxx.xxx.xxx-xx");
    }
    
    public Author(double ID, String name, String email, String cpf) {
        this.setID(ID);
        this.setPeopleName(name);
        this.setPeopleEmail(email);
        this.setPeopleCpf(cpf);
    }
    
    public String showAuthorInfo(){
        return("\n__________________________________________________________\n"
                + "Author ID: " + this.getID() + "\n"
                + "Author Name: " + this.getPeopleName() + "\n"
                + "Author Email: " + this.getPeopleEmail() + "\n"
                + "Author CPF: " + this.getPeopleCpf()
                + "\n__________________________________________________________\n");       
    }
    
     public boolean verifyAuthor (){
        if (this.getPeopleName() == null && this.getPeopleEmail() == null 
                && this.getPeopleCpf() == null){
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
