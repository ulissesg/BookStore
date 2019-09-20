/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ecommerce.products;
import br.ufpr.books.Books;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
/**
 *
 * @author ulisses
 */
public class Publication extends Books{
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        
        
        header();
        menu();
    }
    
    static void header ( ){
        Locale ptBR = new Locale("pt", "BR");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, ptBR);
        
        System.out.println(" __________________________________________________");
        System.out.println("|                                                  |");
        System.out.println("|                   BOOK STORE                     |");
        System.out.println("|                                                  |");
        System.out.println("|       " + dateFormat.format(new Date()) + "        |");
        System.out.println("|__________________________________________________|\n");
    }
    
    static void menu (){
        int option = options();
        switchOptions(option);
    }
    
    static void switchOptions(int option){
        switch (option){
            case 1:
                bookRegistration();
            case 2:
                listBooks();
            case 3:
                readjustPrice();
            default:
                
        }
    }
    
    static int options (){
        printOptions();
        int option = input.nextInt();
        return option;
        
    }
    
    static void printOptions (){
        System.out.println("                      OPTIONS");
        System.out.println(" _________________________________________________\n");
        System.out.println(" 1- Include book.");
        System.out.println(" 2- List books.");
        System.out.println(" 3- Readjust book price.");
        System.out.println(" _________________________________________________\n");
        System.out.println(" Type the number of an option: ");
        
    }
    
    static void bookRegistration (){
        
    }
    
    static void listBooks(){
        
    }
    
    static void readjustPrice(){
        
    }
}
