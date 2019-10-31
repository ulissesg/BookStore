package br.ufpr.ecommerce.products;
import br.ufpr.books.SearchBook;
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
public class Publication extends EBooks implements Books{
    static Scanner input = new Scanner(System.in);
    static ArrayList <Author> authors = new ArrayList<>();
    static ArrayList<Books> books = new ArrayList<>();
    
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
                System.err.println("\n---------------Something went wrong, try again !---------------");
                menu();
        }
    }
    
    // BOOK REGISTRATION
    
    static void bookRegistration (){
        System.out.println("\n Enter the number of books to be registered:");
        System.out.print(" -> ");
        int numBooks = input.nextInt();
        input.nextLine();
        System.out.println("\n Type of books to be registered:");
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
                System.err.println("------------- Something is wrong with the option, try again!-------------\n");
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
                System.out.println("\n -------- author will be used in the book inclusion ! --------\n");
                author = authors.get(authors.size() - 1);
                inputDataEBookAux(author);
                break;
            default: 
                System.err.println("----------- Something is worng with the option, try again !-------------");
                inputDataEBook();
        }
    }
    
    static void inputDataEBookAux(Author author){
        if (author != null) {
           EBooks ebook = new EBooks(author);
           inputDataEBookBook(ebook);
       }else{
           System.err.println("---------- Something is wrong with the author, try again !------------");
           inputDataEBook();
       }
    }
    
    static void inputDataEBookBook(EBooks ebook) {
        System.out.println(" Enter the book name:");
        System.out.print(" -> ");
        ebook.setName(input.nextLine());
        System.out.println(" Enter the book description:");
        System.out.print(" -> ");
        ebook.setDescription(input.nextLine());
        System.out.println(" Enter the book value:");
        System.out.print(" -> ");
        ebook.setValue(input.nextDouble());
        input.nextLine();
        System.out.println(" Enter the book ASIN ( If it dosen't exist type 0 ):");
        System.out.print(" -> ");
        ebook.setAsin(input.nextLine());
        System.out.println(" Enter the book ISBN-10 ( If it dosen't exist type 0 ):");
        System.out.print(" -> ");
        ebook.setIsbn10(input.nextLine());
        System.out.println(" Enter the book ISBN-13 ( If it dosen't exist type 0 ):");
        System.out.print(" -> ");
        ebook.setIsbn13(input.nextLine());
        System.out.println(" Enter the book format:");
        System.out.print(" -> ");
        ebook.setFormat(input.nextLine());
        verifyTipsEbook(ebook);
        System.out.println(" Enter the book size:");
        System.out.print(" -> ");
        ebook.setFileSize(input.nextDouble());
        input.nextLine();
        books.add(ebook);
        
        System.out.println("\n------------------- Book added with success !--------------------");
        
    }
    
    static void verifyTipsEbook(EBooks ebook){
        System.out.println(" Enter 'yes' for existent vocabulary tips and 'no' for not existent:");
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
                System.out.println("\n -------- author will be used in the book inclusion ! --------\n");
                author = authors.get(authors.size() - 1);
                inputDataPrintedBookAux(author);
                break;
            default: 
                System.err.println("------------ Something is worng with the option, try again !-------------");
                inputDataPrintedBook();
        }
    }
    
    static void inputDataPrintedBookAux(Author author){
        if (author != null) {
           PrintedBooks book = new PrintedBooks(author);
            inputDataPrintedBookBook(book);
       }else{
           System.err.println("------------ Something is wrong with the author, try again !-------------");
           inputDataPrintedBook();
       }
    }
    
    static void inputDataPrintedBookBook (PrintedBooks book){
        System.out.println(" Enter the book name:");
        System.out.print(" -> ");
        book.setName(input.nextLine());
        System.out.println(" Enter the book description:");
        System.out.print(" -> ");
        book.setDescription(input.nextLine());
        System.out.println(" Enter the book value:");
        System.out.print(" -> ");
        book.setValue(input.nextDouble());
        input.nextLine();
        System.out.println(" Enter the book ISBN-10 ( If it dosen't exist type 0 ):");
        System.out.print(" -> ");
        book.setIsbn10(input.nextLine());
        System.out.println(" Enter the book ISBN-13 ( If it dosen't exist type 0 ):");
        System.out.print(" -> ");
        book.setIsbn13(input.nextLine());
        System.out.println(" Enter the book width:");
        System.out.print(" -> ");
        book.setWidth(input.nextDouble());
        input.nextLine();
        System.out.println(" Enter the book height:");
        System.out.print(" -> ");
        book.setHeight(input.nextDouble());
        input.nextLine();
        System.out.println(" Enter the book Depth:");
        System.out.print(" -> ");
        book.setDepth(input.nextDouble());
        input.nextLine();
        System.out.println(" Enter the book weight:");
        System.out.print(" -> ");
        book.setWeight(input.nextDouble());
        input.nextLine();        
        books.add(book);
        
        System.out.println("\n------------------- Book added with success !--------------------");
    }
    
    // AUTHOR REGISTRATION
    
    static void authorRegistration(){
        Author author2 = new Author();
        Author author = new Author();
        inputDataAuthor(author);
        if (authors.isEmpty()){
            putAuthorList(author);
        }else{
            author2 = author2.searchAuthor(author.getID(), authors);
            if (author2 == null){
                putAuthorList(author);
            }else{
                System.err.println("\n---------- Author ID already registered !----------");
            }
        }
    }
    
    static void putAuthorList(Author author){
        authors.add(author);
        System.out.println("\n\n -----------Author registered with success !------------");
    }
    
    static void inputDataAuthor(Author author){
        
        System.out.println(" Enter an ID (number) for the author:");
        System.out.print(" -> ");
        author.setID(input.nextDouble());
        input.nextLine();
        System.out.println(" Enter the Author name:");
        System.out.print(" -> ");
        author.setPeopleName(input.nextLine());
        System.out.println(" Enter the Author e-mail:");
        System.out.print(" -> ");
        author.setPeopleEmail(input.nextLine());
        System.out.println(" Enter the Author CPF:");
        System.out.print(" -> ");
        author.setPeopleCpf(input.nextLine());     
    }
    
    // LIST BOOKS
    
    static void listBooks(){
        if (books.isEmpty()){
            System.err.println("---------------List of books is Empty !-----------------");
        }else{
            System.out.println("\n\n------------------- LIST OF BOOKS --------------------");
            books.forEach(o->System.out.println(o.showInfo()));
        }
    }
    
    // LIST AUTHORS    
    
    static void listAuthors(){
        if (authors.isEmpty()){
            System.err.println("---------------List of authors is Empty !-----------------");
        }else{
            System.out.println("\n\n-------------- LIST OF AUTHORS ----------------");
            authors.forEach(o->System.out.println(o.showAuthorInfo()));
        }  
    }
    
    // READJUSTMENT PRICE

    static void readjustPrice(){
        String bookName;
        double readjustment;

        System.out.println(" Enter the name of the book that you wanna readjust the price:");
        System.out.print(" -> ");
        bookName = input.nextLine();
        System.out.println(" Enter the percentage of readjust:");
        System.out.print(" -> ");
        readjustment = input.nextDouble();
        
        if (readjustment <= 30){
            readjustPriceBook(bookName, readjustment);
        }else{
            System.err.println("---------- Something is wrong with the readjustment value, try again !-----------");
            readjustPrice();
        }
       
    }
    
    static void readjustPriceBook(String bookName, double readjustment){
        int index;
        Books book = new SearchBook();
        book = book.searchBook(bookName, books);
        if (book == null){
            System.err.println("------------Book wasn't found!--------------");
        }else if (book.priceAdjustment(readjustment) == true){
            index = books.indexOf(book);
            books.set(index, book);
            System.out.println("\n----------- Price readjusted with success !-----------");
        }else{
            System.out.println("------------ Something went wrong with the value, try again ! ------------");
            readjustPrice();
        }
    }
}
