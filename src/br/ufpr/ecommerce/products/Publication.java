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
    
    // mover para implementar a8utor static Author author = new Author();
    static Scanner input = new Scanner(System.in);
    static ArrayList <Author> authors = new ArrayList<>();
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
                authorRegistration();
                menu();
            case 3:
                listBooks();
                menu();
            case 4:
                listAuthors();
                menu();
            case 5:
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
        System.out.println(" 2- Include Author.");
        System.out.println(" 3- List books.");
        System.out.println(" 4- List Authors.");
        System.out.println(" 5- Readjust book price.");
        System.out.println(" _________________________________________________\n");
        System.out.println(" Enter the number of an option: ");
        
    }
    
    static void bookRegistration (){
        System.out.println("Enter the number of books to be registered");
        int numBooks = input.nextInt();
        System.out.println("Enter of books to be registered");
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
            System.err.println("Enter of book error");
        }
        
    }
    
    static void inputDataEBook(){
//        Author author = new Author();
//        author = authors.get(0);
////        inputDataAuthor();
//        
//       if (author.verifyAuthor()) {
//           EBooks ebook = new EBooks(author);
//           inputDataEBookBook(ebook);
//       }else{
//           System.out.println("There's no author");
//       }
    }
    
    static void inputDataAuthor(Author author){
        
        System.out.println("Enter an ID (number) for the author");
        author.setID(input.nextDouble());
        System.out.println("Enter the Author name:");
        author.setPeapleName(input.next());
        System.out.println("Enter the Author e-mail:");
        author.setPeapleEmail(input.next());
        System.out.println("Enter the Author CPF:");
        author.setPeapleCpf(input.next());     
    }

    static void inputDataEBookBook(EBooks ebook) {
        System.out.println("Enter the book name");
        ebook.setName(input.next());
        System.out.println("Enter the book description");
        ebook.setDescription(input.next());
        System.out.println("Enter the book value");
        ebook.setValue(input.nextDouble());
        System.out.println("Enter the book ASIN ( If it dosen't exist type 0 )");
        ebook.setAsin(input.next());
        System.out.println("Enter the book ISBN-10 ( If it dosen't exist type 0 )");
        ebook.setIsbn10(input.next());
        System.out.println("Enter the book ISBN-13 ( If it dosen't exist type 0 )");
        ebook.setIsbn13(input.next());
        System.out.println("Enter the book format");
        ebook.setFormat(input.next());
        VTEBooks(ebook);
        System.out.println("Enter the book size");
        ebook.setFileSize(input.nextDouble());
        System.out.println("\n---------------------------------------------------------\n");
        
        ebooks.add(ebook);
        
    }
    
    static void VTEBooks(EBooks ebook){
        System.out.println("Enter 'yes' for existent vocabulary tips and 'no' for not existent");
        String answer = input.next();
        if (answer.equalsIgnoreCase("yes")){
            ebook.setVocabularyTips(true);
        }else{
            ebook.setVocabularyTips(false);
        }
    }
    
    static void inputDataPrintedBook(){
         
//        inputDataAuthor();
        
//        if (author.verifyAuthor()) {
//            PrintedBooks printedBook = new PrintedBooks(author);
//            inputDataPrintedBookBook(printedBook);
//        }else{
//            System.out.println("There's no author");
//        }
    }
    
    static void inputDataPrintedBookBook (PrintedBooks printedBook){
        System.out.println("Enter the book name");
        printedBook.setName(input.next());
        System.out.println("Enter the book description");
        printedBook.setDescription(input.next());
        System.out.println("Enter the book value");
        printedBook.setValue(input.nextDouble());
        System.out.println("Enter the book ISBN-10 ( If it dosen't exist type 0 )");
        printedBook.setIsbn10(input.next());
        System.out.println("Enter the book ISBN-13 ( If it dosen't exist type 0 )");
        printedBook.setIsbn13(input.next());
        System.out.println("Enter the book width");
        printedBook.setWidth(input.nextDouble());
        System.out.println("Enter the book height");
        printedBook.setHeight(input.nextDouble());
        System.out.println("Enter the book Depth");
        printedBook.setDepth(input.nextDouble());
        System.out.println("Enter the book weight");
        printedBook.setWeight(input.nextDouble());
        System.out.println("\n---------------------------------------------------------\n");
        
        printedBooks.add(printedBook);
    }
    
    static void authorRegistration(){
        Author author = new Author();
        inputDataAuthor(author);
        // TODO checkar se o author existe antes de adicionar.
        authors.add(author);
    }
    

    static void listAuthors(){
        if (authors.isEmpty()){
            System.out.println("---------------List of authors is Empty-----------------");
        }else{
            authors.forEach(o->System.out.println(o.showAuthorInfo()));
            
        }  
    }
    
    
    static void listBooks(){
        // bug imprime imprime o case e da erro
        menuListBooks();
        int option = input.nextInt();
        switch (option){
            case 1:
                showListEBooks();
            case 2:
                showListPrintedBooks();
            case 3: 
                showListEBooks();
                System.out.println("----------------------------------------------------");
                showListPrintedBooks();
            default:
                System.out.println("Something went wrong, Try again");
                listBooks();
        }
    }
    
    static void menuListBooks(){
        System.out.println("Enter what type of books to list:");
        System.out.println("________________________________");
        System.out.println("1- E books");
        System.out.println("2- Printed books");
        System.out.println("3- All types");
        System.out.println("________________________________");
    }
    
    static void showListEBooks(){
        if (ebooks.isEmpty()){
            System.out.println("---------------List of Ebooks is Empty-----------------");
        }else {
            ebooks.forEach(o->System.out.println(o.showInfo()));
        }
    }
    
    static void showListPrintedBooks(){
        if (printedBooks.isEmpty()){
            System.out.println("---------------List of Printed Books is Empty-----------------");
        }else{
            printedBooks.forEach(o->System.out.println(o.showInfo()));
        }
    }
    
    static void readjustPrice(){
        
    }
}
