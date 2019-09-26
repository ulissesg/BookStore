/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ecommerce.products;
import br.ufpr.books.Books;
import br.ufpr.books.EBooks;
import br.ufpr.books.PrintedBooks;
import br.ufpr.people.Author;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
/**
 *
 * @author ulisses
 */
public class Publication extends Books{
    
    static Author author = new Author();
    static Scanner input = new Scanner(System.in);
    static ArrayList<EBooks> ebooks = new ArrayList<>();
    static ArrayList<PrintedBooks> printedBooks = new ArrayList<>();
    
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
        System.out.println("|       " + dateFormat.format(new Date()) + "        |"); // colocar hora
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
                menu();
            case 2:
                listBooks();
                menu();
            case 3:
                readjustPrice();
                menu();
            default:
                System.out.println("\nSomething went wrong !, try again");
                menu();
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
        System.out.println("Type the number of books to be registered");
        int numBooks = input.nextInt();
        System.out.println("Type of books to be registered");
        System.out.println(" _________________________________________________");
        System.out.println("1- E books");
        System.out.println("2- Printed books");
        int typeBooks = input.nextInt();
        
        if (typeBooks == 1){
            for (int x = 0; x < numBooks; x++){
                inputDataEBook();
            }
        }else if (typeBooks == 2){
            for (int x = 0; x < numBooks; x++){
                inputDataPrintedBook();
            }
        }else{
            System.err.println("Type of book error");
        }
        
    }
    
    static void inputDataEBook(){
        
        inputDataAuthor();
        
       if (author.verifyAuthor()) {
           EBooks ebook = new EBooks(author);
           inputDataEBookBook(ebook);
       }else{
           System.out.println("There's no author");
       }
    }
    
    static void inputDataAuthor(){
        System.out.println("Type the Author name:");
        author.setPeapleName(input.next());
        System.out.println("Type the Author e-mail:");
        author.setPeapleEmail(input.next());
        System.out.println("Type the Author CPF:");
        author.setPeapleCpf(input.next());
    }
    
    static void inputDataEBookBook(EBooks ebook) {
        System.out.println("Type the book name");
        ebook.setName(input.next());
        System.out.println("Type the book description");
        ebook.setDescription(input.next());
        System.out.println("Type the book value");
        ebook.setValue(input.nextDouble());
        System.out.println("Type the book ASIN ( If it dosen't exist type 0 )");
        ebook.setAsin(input.next());
        System.out.println("Type the book ISBN-10 ( If it dosen't exist type 0 )");
        ebook.setIsbn10(input.next());
        System.out.println("Type the book ISBN-13 ( If it dosen't exist type 0 )");
        ebook.setIsbn13(input.next());
        System.out.println("Type the book format");
        ebook.setFormat(input.next());
        VTEBooks(ebook);
        System.out.println("Type the book size");
        ebook.setFileSize(input.nextDouble());
        System.out.println("\n---------------------------------------------------------\n");
        
        ebooks.add(ebook);
        
    }
    
    static void VTEBooks(EBooks ebook){
        System.out.println("Type 'yes' for existent vocabulary tips and 'no' for not existent");
        String answer = input.next();
        if (answer.equalsIgnoreCase("yes")){
            ebook.setVocabularyTips(true);
        }else{
            ebook.setVocabularyTips(false);
        }
    }
    
    static void inputDataPrintedBook(){
         
        inputDataAuthor();
        
        if (author.verifyAuthor()) {
            PrintedBooks printedBook = new PrintedBooks(author);
            inputDataPrintedBookBook(printedBook);
        }else{
            System.out.println("There's no author");
        }
    }
    
    static void inputDataPrintedBookBook (PrintedBooks printedBook){
        System.out.println("Type the book name");
        printedBook.setName(input.next());
        System.out.println("Type the book description");
        printedBook.setDescription(input.next());
        System.out.println("Type the book value");
        printedBook.setValue(input.nextDouble());
        System.out.println("Type the book ISBN-10 ( If it dosen't exist type 0 )");
        printedBook.setIsbn10(input.next());
        System.out.println("Type the book ISBN-13 ( If it dosen't exist type 0 )");
        printedBook.setIsbn13(input.next());
        System.out.println("Type the book width");
        printedBook.setWidth(input.nextDouble());
        System.out.println("Type the book height");
        printedBook.setHeight(input.nextDouble());
        System.out.println("Type the book Depth");
        printedBook.setDepth(input.nextDouble());
        System.out.println("Type the book weight");
        printedBook.setWeight(input.nextDouble());
        System.out.println("\n---------------------------------------------------------\n");
        
        printedBooks.add(printedBook);
    }
    
    static void listBooks(){
        menuListBooks();
        int option = input.nextInt();
        switch (option){
            case 1:
                if (!ebooks.isEmpty()){
                    ebooks.forEach(o->System.out.println(o.showInfo()));
                }else {
                    System.out.println("---------------Empty-----------------");
                    menu();
                }
            case 2:
                if (!printedBooks.isEmpty()){
                    printedBooks.forEach(o->System.out.println(o.showInfo()));
                }else{
                    System.out.println("---------------Empty-----------------");
                    menu();
                }
            case 3: 
                if (!ebooks.isEmpty() && !printedBooks.isEmpty()){
                    ebooks.forEach(o->System.out.println(o.showInfo()));
                    System.out.println("\n ------------------------------------------------------------\n");
                    printedBooks.forEach(o->System.out.println(o.showInfo()));
                }else {
                    System.out.println("---------------Empty-----------------");
                    menu();
                }
                
            default:
                System.out.println("Something went wrong, Try again");
                listBooks();
        }
    }
    
    static void menuListBooks(){
        System.out.println("Type what type of books to list:");
        System.out.println("________________________________");
        System.out.println("1- E books");
        System.out.println("2- Printed books");
        System.out.println("3- All types");
        System.out.println("________________________________");
    }
    
    static void readjustPrice(){
        
    }
}
