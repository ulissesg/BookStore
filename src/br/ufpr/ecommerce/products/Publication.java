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
        System.out.println(" _________________________________________________");
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
        int option;
        menuInput();
        option = input.nextInt();
        input.nextLine();  
        switchDataEbook(option);
    }
    
    static void switchDataEbook(int option){
        Author author = new Author();
        
        switch (option){
            case 1:
                System.out.println("Enter the author ID:");
                double id = input.nextDouble();
                author = author.searchAuthor(id, authors);  
                inputDataEBookAux(author);
                break;
            case 2:
                listAuthors();
                inputDataEBook();
                break;
            case 3: 
                authorRegistration();
                System.out.println("\n__________________________________________");
                System.out.println("author will be used in the book inclusion.");
                System.out.println("\n__________________________________________");
                author = authors.get(authors.size() - 1);
                inputDataEBookAux(author);
                break;
            default: 
                System.err.println("Something is worng with the option, try again.");
                inputDataEBook();
        }
    }
    
    static void inputDataEBookAux(Author author){
        if (author != null) {
           EBooks ebook = new EBooks(author);
           inputDataEBookBook(ebook);
       }else{
           System.out.println("Something is wrong with the author, try again.");
           inputDataEBook();
       }
    }
    
    static void menuInput(){
        System.out.println("Enter the number of an option:");
        System.out.println("______________________________");
        System.out.println("1- Enter de ID of an existent Author");
        System.out.println("2- List all existent authors");
        System.out.println("3- Register a new Author");
        System.out.println("______________________________");
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
        int option;
        menuInput();
        option = input.nextInt();
        input.nextLine(); 
        switchDataPrintedBook(option);
    }
    static void switchDataPrintedBook(int option){
        Author author = new Author();
        
        switch (option){
            case 1:
                System.out.println("Enter the author ID:");
                double id = input.nextDouble();
                author = author.searchAuthor(id, authors);  
                inputDataPrintedBookAux(author);
                break;
            case 2:
                listAuthors();
                inputDataPrintedBook();
                break;
            case 3: 
                authorRegistration();
                System.out.println("\n__________________________________________");
                System.out.println("author will be used in the book inclusion.");
                System.out.println("\n__________________________________________");
                author = authors.get(authors.size() - 1);
                inputDataPrintedBookAux(author);
                break;
            default: 
                System.err.println("Something is worng with the option, try again.");
                inputDataPrintedBook();
        }
    }
    
    static void inputDataPrintedBookAux(Author author){
        if (author != null) {
           PrintedBooks printedBook = new PrintedBooks(author);
            inputDataPrintedBookBook(printedBook);
       }else{
           System.out.println("Something is wrong with the author, try again.");
           inputDataPrintedBook();
       }
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
        authors.add(author); //TODO check if author already exist.
    }
    

    static void listAuthors(){
        if (authors.isEmpty()){
            System.out.println("---------------List of authors is Empty-----------------");
        }else{
            authors.forEach(o->System.out.println(o.showAuthorInfo()));
            
        }  
    }
    
    
    static void listBooks(){
        menuListBooks();
        int option = input.nextInt();
        switchListBooks(option);
    }
    
    static void switchListBooks(int option){
        switch (option){
            case 1:
                showListEBooks();
                break;
            case 2:
                showListPrintedBooks();
                break;
            case 3: 
                showListEBooks();
                System.out.println("----------------------------------------------------");
                showListPrintedBooks();
                break;
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
                
        String bookName;
        double readjustment;
        int option;
        
        menuReadjustPrice();
        option = input.nextInt();
        input.nextLine();

        
        System.out.println("Enter the name of the book that you wanna readjust the price:");
        bookName = input.nextLine();
        
        System.out.println("Enter the percentage of readjust");
        readjustment = input.nextDouble();
        
        if (readjustment <= 30){
            switchReadjustPrice(option, bookName, readjustment);
        }else{
            
        }
       
    }
    
    static void switchReadjustPrice(int option, String bookName, double readjustment){
        int index;
        switch(option){
            case 1:
                reajustPriceEBook(bookName, readjustment);
                break;
            case 2:
                readjustPricePrintedBook(bookName, readjustment);
                break;
            default:
                System.err.println("Something went wrong with the option, try again");
                readjustPrice(); 
        }
    }
        
    static void reajustPriceEBook (String bookName, double readjustment){
        int index;
        EBooks ebook = new EBooks();
        ebook = ebook.searchEbook(bookName, ebooks);
        if (ebook.priceAdjustment(readjustment) == true){
            System.out.println("Price readjusted with success");
        }else{
            System.out.println("Something went wrong with the value, try again");
            readjustPrice();
        }
        index = ebooks.indexOf(ebook);
        ebooks.set(index, ebook);
        // tratar ebook nulo
    }
    
    static void readjustPricePrintedBook(String bookName, double readjustment){
        int index;
        PrintedBooks printedBook = new PrintedBooks();
        printedBook = printedBook.searchPrintedBook(bookName, printedBooks);
        if (printedBook.priceAdjustment(readjustment) == true){
            System.out.println("Price readjusted with success");
        }else{
            System.out.println("Something went wrong with the value, try again");
            readjustPrice();
        }
        index = printedBooks.indexOf(printedBook);
        printedBooks.set(index, printedBook);
        // tratar printedBook nulo;
    }
    
    static void menuReadjustPrice(){
        System.out.println("Enter the number of one option:");
        System.out.println("_____________________________________");
        System.out.println("1- Change price of an E Book");
        System.out.println("2- Change price of an Printed Book");
        System.out.println("_____________________________________");
    }
}
