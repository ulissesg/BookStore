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
        this.setPeapleName("xxxxxxxxxxxxxx");
        this.setPeapleEmail("example@gmail.com");
        this.setPeapleCpf("xxx.xxx.xxx-xx");
    }
    
    public void showAuthorInfo(){
        if (this.verifyAuthor() == true){
            System.out.println("Author Name: " + this.getPeapleName() + "\n"
            + "Author Email: " + this.getPeapleEmail() + "\n"
            + "Author CPF: " + this.getPeapleCpf() + "\n");
        }
        else{
            System.err.println("There`s no author");
        }
        
    }
    
     public boolean verifyAuthor (){
        if (this.getPeapleName() == null && this.getPeapleEmail() == null 
                && this.getPeapleCpf() == null){
            return false;
        }
        return true;
    }
}
