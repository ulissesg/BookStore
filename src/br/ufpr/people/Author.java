/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.people;

/**
 *
 * @author ulisses
 */
public class Author extends People{
    
    public Author() {
        this.setName("xxxxxxxxxxxxxx");
        this.setEmail("example@gmail.com");
        this.setCpf("xxx.xxx.xxx-xx");
    }
    
    public void showAuthorInfo(){
        if (this.verifyAuthor() == true){
            System.out.println("Author Name: " + this.getName() + "\n"
            + "Author Email: " + this.getEmail() + "\n"
            + "Author CPF: " + this.getCpf() + "\n");
        }
        else{
            System.err.println("There`s no author");
        }
        
    }
    
     public boolean verifyAuthor (){
        if (this.getName() == null && this.getEmail() == null 
                && this.getCpf() == null){
            return false;
        }
        return true;
    }
}
