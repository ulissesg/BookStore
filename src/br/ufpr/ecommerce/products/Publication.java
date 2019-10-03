package br.ufpr.ecommerce.products;
import br.ufpr.books.Books;
import br.ufpr.books.EBooks;
import br.ufpr.books.PrintedBooks;
import br.ufpr.people.Author;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;
/**
 *
 * @author ulisses
 */
public class Publication extends Books{
    
    static Scanner input = new Scanner(System.in);
    static ArrayList <Author> authors = new ArrayList<>();
    static ArrayList<EBooks> ebooks = new ArrayList<>();
    static ArrayList<PrintedBooks> printedBooks = new ArrayList<>();
    
    public static void main(String[] args) {
        header();
        menu();
    }
    // MENU
    static void header ( ){
        System.out.println(" __________________________________________________");
        System.out.println("|                                                  |");
        System.out.println("|                   BOOK STORE                     |");
        System.out.println("|__________________________________________________|\n");
        dateTime();
    }
    
    static void dateTime(){
        Calendar dataAtual = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("hh:mm:ss");
        String time = dateFormat1.format(dataAtual.getTime());
        
        Locale ptBR = new Locale("pt", "BR");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, ptBR);
        String date = dateFormat.format(new Date());
        
        System.out.println("   " + date + "  " + time);
    }
    
    static void menu (){
        int option = options();
        switchOptions(option);
    }
    
    static int options (){
        printOptions();
        System.out.print(" -> ");
        int option = input.nextInt();
        input.nextLine();
        return option;
    }
    
    static void printOptions (){
        System.out.println("\n\n                       MENU");
        System.out.println("_________________________________________________\n");
        System.out.println(" 1- Include book.");
        System.out.println(" 2- Include Author.");
        System.out.println(" 3- List books.");
        System.out.println(" 4- List Authors.");
        System.out.println(" 5- Readjust book price.");
        System.out.println(" 6- Exit program.");
        System.out.println("_________________________________________________\n");
        System.out.println(" Enter the number of an option: ");
    }
    
    static void switchOptions(int option){
        switch (option){
            case 1:
                bookRegistration();
                menu();
                break;
            case 2: 
                authorRegistration();
                menu();
                break;
            case 3:
                listBooks();
                menu();
                break;
            case 4:
                listAuthors();
                menu();
                break;
            case 5:
                readjustPrice();
                menu();
                break;
            case 6:
                System.exit(0);
            default:
                System.err.println("\nSomething went wrong !, try again");
                menu();
        }
    }
    
    // BOOK REGISTRATION
    
    static void bookRegistration (){
        System.out.println("\n Enter the number of books to be registered:");
        System.out.print(" -> ");
        int numBooks = input.nextInt();
        input.nextLine();
        System.out.println("\n Type of books to be registered");
        System.out.println("_________________________________________________");
        System.out.println(" 1- E books");
        System.out.println(" 2- Printed books");
        System.out.println("_________________________________________________");
        System.out.print(" -> ");
        int typeBooks = input.nextInt();
        input.nextLine();
        switchBookRegistration(typeBooks, numBooks);
    }
    
    static void switchBookRegistration(int typeBooks, int numBooks){
        switch(typeBooks){
            case 1:
                for (int x = 0; x < numBooks; x++){
                    inputDataEBook();
                }
                break;
            case 2:
                for (int x = 0; x < numBooks; x++){
                    inputDataPrintedBook();
                }
                break;
            default:
                System.err.println(" Something is wrong with the option, try again!\n");
                bookRegistration();
        }
    }
    
    static void inputDataEBook(){
        int option;
        menuInput();
        System.out.print(" -> ");
        option = input.nextInt();
        input.nextLine();  
        switchDataEbook(option);
    }
    
    static void menuInput(){
        System.out.println("\n Enter the number of an option:");
        System.out.println("______________________________________");
        System.out.println(" 1- Enter de ID of an existent Author");
        System.out.println(" 2- List all existent authors");
        System.out.println(" 3- Register a new Author");
        System.out.println("______________________________________");
    }
    
    static void switchDataEbook(int option){
        Author author = new Author();
        
        switch (option){
            case 1:
                System.out.println(" Enter the author ID:");
                System.out.print(" -> ");
                double id = input.nextDouble();
                input.nextLine();
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
                System.out.print(" Author will be used in the book inclusion !");
                System.out.println("\n__________________________________________");
                author = authors.get(authors.size() - 1);
                inputDataEBookAux(author);
                break;
            default: 
                System.err.println(" Something is worng with the option, try again.");
                inputDataEBook();
        }
    }
    
    static void inputDataEBookAux(Author author){
        if (author != null) {
           EBooks ebook = new EBooks(author);
           inputDataEBookBook(ebook);
       }else{
           System.err.println(" Something is wrong with the author, try again.");
           inputDataEBook();
       }
    }
    
    static void inputDataEBookBook(EBooks ebook) {
        System.out.println(" Enter the book name");
        System.out.print(" -> ");
        ebook.setName(input.nextLine());
        System.out.println(" Enter the book description");
        System.out.print(" -> ");
        ebook.setDescription(input.nextLine());
        System.out.println(" Enter the book value");
        System.out.print(" -> ");
        ebook.setValue(input.nextDouble());
        input.nextLine();
        System.out.println(" Enter the book ASIN ( If it dosen't exist type 0 )");
        System.out.print(" -> ");
        ebook.setAsin(input.nextLine());
        System.out.println(" Enter the book ISBN-10 ( If it dosen't exist type 0 )");
        System.out.print(" -> ");
        ebook.setIsbn10(input.nextLine());
        System.out.println(" Enter the book ISBN-13 ( If it dosen't exist type 0 )");
        System.out.print(" -> ");
        ebook.setIsbn13(input.nextLine());
        System.out.println(" Enter the book format");
        System.out.print(" -> ");
        ebook.setFormat(input.nextLine());
        VTEBooks(ebook);
        System.out.println(" Enter the book size");
        System.out.print(" -> ");
        ebook.setFileSize(input.nextDouble());
        input.nextLine();
        ebooks.add(ebook);
        
        System.out.println("------------------- Book added with success--------------------");
        
    }
    
    static void VTEBooks(EBooks ebook){
        System.out.println(" Enter 'yes' for existent vocabulary tips and 'no' for not existent");
        System.out.print(" -> ");
        String answer = input.nextLine();
        if (answer.equalsIgnoreCase("yes")){
            ebook.setVocabularyTips(true);
        }else{
            ebook.setVocabularyTips(false);
        }
    }
    
    static void inputDataPrintedBook(){
        int option;
        menuInput();
        System.out.print(" -> ");
        option = input.nextInt();
        input.nextLine(); 
        switchDataPrintedBook(option);
    }
    
    static void switchDataPrintedBook(int option){
        Author author = new Author();
        
        switch (option){
            case 1:
                System.out.println(" Enter the author ID:");
                System.out.print(" -> ");
                double id = input.nextDouble();
                input.nextLine();
                author = author.searchAuthor(id, authors);  
                inputDataPrintedBookAux(author);
                break;
            case 2:
                listAuthors();
                inputDataPrintedBook();
                break;
            case 3: 
                authorRegistration();
                System.out.println("\n____________________________________________");
                System.out.print(" author will be used in the book inclusion.");
                System.out.println("____________________________________________\n");
                author = authors.get(authors.size() - 1);
                inputDataPrintedBookAux(author);
                break;
            default: 
                System.err.println(" Something is worng with the option, try again.");
                inputDataPrintedBook();
        }
    }
    
    static void inputDataPrintedBookAux(Author author){
        if (author != null) {
           PrintedBooks printedBook = new PrintedBooks(author);
            inputDataPrintedBookBook(printedBook);
       }else{
           System.err.println(" Something is wrong with the author, try again.");
           inputDataPrintedBook();
       }
    }
    
    static void inputDataPrintedBookBook (PrintedBooks printedBook){
        System.out.println(" Enter the book name");
        System.out.print(" -> ");
        printedBook.setName(input.nextLine());
        System.out.println(" Enter the book description");
        System.out.print(" -> ");
        printedBook.setDescription(input.nextLine());
        System.out.println(" Enter the book value");
        System.out.print(" -> ");
        printedBook.setValue(input.nextDouble());
        input.nextLine();
        System.out.println(" Enter the book ISBN-10 ( If it dosen't exist type 0 )");
        System.out.print(" -> ");
        printedBook.setIsbn10(input.nextLine());
        System.out.println(" Enter the book ISBN-13 ( If it dosen't exist type 0 )");
        System.out.print(" -> ");
        printedBook.setIsbn13(input.nextLine());
        System.out.println(" Enter the book width");
        System.out.print(" -> ");
        printedBook.setWidth(input.nextDouble());
        input.nextLine();
        System.out.println(" Enter the book height");
        System.out.print(" -> ");
        printedBook.setHeight(input.nextDouble());
        input.nextLine();
        System.out.println(" Enter the book Depth");
        System.out.print(" -> ");
        printedBook.setDepth(input.nextDouble());
        input.nextLine();
        System.out.println(" Enter the book weight");
        System.out.print(" -> ");
        printedBook.setWeight(input.nextDouble());
        input.nextLine();
        System.out.println("\n_____________________________________________________\n");
        
        printedBooks.add(printedBook);
    }
    
    // AUTHOR REGISTRATION
    
    static void authorRegistration(){
//        Author author2 = new Author(); //verify when searchAuthor send back "null"
        Author author = new Author();
        inputDataAuthor(author);
//        author2 = author2.searchAuthor(author.getID(), authors);
//        if (author2.equals(author)){
//            System.err.println(" Author ID already registered !");
//        }else{
            authors.add(author);
            System.out.println(" -----------Author registered with success !------------");
//        }
    }
    
    static void inputDataAuthor(Author author){
        
        System.out.println(" Enter an ID (number) for the author");
        System.out.print(" -> ");
        author.setID(input.nextDouble());
        input.nextLine();
        System.out.println(" Enter the Author name:");
        System.out.print(" -> ");
        author.setPeapleName(input.nextLine());
        System.out.println(" Enter the Author e-mail:");
        System.out.print(" -> ");
        author.setPeapleEmail(input.nextLine());
        System.out.println(" Enter the Author CPF:");
        System.out.print(" -> ");
        author.setPeapleCpf(input.nextLine());     
    }
    
    // LIST BOOKS
    
    static void listBooks(){
        menuListBooks();
        System.out.print(" -> ");
        int option = input.nextInt();
        input.nextLine();
        switchListBooks(option);
    }
    
    static void menuListBooks(){
        System.out.println(" Enter what type of books to list:");
        System.out.println("___________________________________");
        System.out.println(" 1- E books");
        System.out.println(" 2- Printed books");
        System.out.println(" 3- All types");
        System.out.println("___________________________________");
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
                showListPrintedBooks();
                break;
            default:
                System.err.println("Something went wrong, Try again");
                listBooks();
        }
    }
    
    static void showListEBooks(){
        if (ebooks.isEmpty()){
            System.err.println("---------------List of Ebooks is Empty-----------------");
        }else {
            System.out.println("\n\n------------------- LIST OF E-BOOKS --------------------");
            ebooks.forEach(o->System.out.println(o.showInfo()));
        }
    }
    
        static void showListPrintedBooks(){
        if (printedBooks.isEmpty()){
            System.err.println("---------------List of Printed Books is Empty-----------------");
        }else{
            System.out.println("\n\n---------------- LIST OF PRINTED BOOKS -----------------");
            printedBooks.forEach(o->System.out.println(o.showInfo()));
        }
    }
    
    // LIST AUTHORS    
    
    static void listAuthors(){
        if (authors.isEmpty()){
            System.err.println("---------------List of authors is Empty-----------------");
        }else{
            System.out.println("\n\n-------------- LIST OF AUTHORS ----------------");
            authors.forEach(o->System.out.println(o.showAuthorInfo()));
        }  
    }
    
    // READJUSTMENT PRICE

    static void readjustPrice(){
        String bookName;
        double readjustment;
        int option;
        
        menuReadjustPrice();
        System.out.print(" -> ");
        option = input.nextInt();
        input.nextLine();
        System.out.println(" Enter the name of the book that you wanna readjust the price:");
        System.out.print(" -> ");
        bookName = input.nextLine();
        System.out.println(" Enter the percentage of readjust");
        System.out.print(" -> ");
        readjustment = input.nextDouble();
        
        if (readjustment <= 30){
            switchReadjustPrice(option, bookName, readjustment);
        }else{
            System.err.println(" Something is wrong with the readjustment value, try again");
            readjustPrice();
        }
       
    }
    
    static void menuReadjustPrice(){
        System.out.println(" Enter the number of one option:");
        System.out.println("_____________________________________");
        System.out.println(" 1- Change price of an E Book");
        System.out.println(" 2- Change price of an Printed Book");
        System.out.println("_____________________________________");
    }
    
    static void switchReadjustPrice(int option, String bookName, double readjustment){
        switch(option){
            case 1:
                reajustPriceEBook(bookName, readjustment);
                break;
            case 2:
                readjustPricePrintedBook(bookName, readjustment);
                break;
            default:
                System.err.println(" Something went wrong with the option, try again");
                readjustPrice(); 
        }
    }
        
    static void reajustPriceEBook (String bookName, double readjustment){
        int index;
        EBooks ebook = new EBooks();
        ebook = ebook.searchEbook(bookName, ebooks);
        if (ebook == null){
            System.err.println("Book wasn't found!");
        }else if (ebook.priceAdjustment(readjustment) == true){
            System.out.println(" Price readjusted with success");
        }else{
            System.err.println(" Something went wrong with the value, try again");
            readjustPrice();
        }
        index = ebooks.indexOf(ebook);
        ebooks.set(index, ebook);
    }
    
    static void readjustPricePrintedBook(String bookName, double readjustment){
        int index;
        PrintedBooks printedBook = new PrintedBooks();
        printedBook = printedBook.searchPrintedBook(bookName, printedBooks);
        if (printedBook == null){
            System.err.println("Book wasn't found!");
        }else if (printedBook.priceAdjustment(readjustment) == true){
            System.out.println("\n----------- Price readjusted with success -----------");
        }else{
            System.out.println(" Something went wrong with the value, try again");
            readjustPrice();
        }
        index = printedBooks.indexOf(printedBook);
        printedBooks.set(index, printedBook);
    }
}
