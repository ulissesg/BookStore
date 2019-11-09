package br.ufpr.books;

import br.ufpr.people.Author;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author ulisses
 */
public class PrintedBooks implements Books{
    private String name;
    private String description;
    private double value;
    private String isbn13;
    private String isbn10;
    private Author author = new Author();
    private double height;
    private double width;
    private double depth;
    private double weight;
    
    
    public PrintedBooks (Author author){
        this.author = author;
    }
    
    public PrintedBooks(){
        
    }
    
    @Override
    public String showInfo(){
        
        Locale ptBR = new Locale("pt", "BR");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(ptBR);
        
        return("\n________________________________________________________\n"
                + "Type: Printed book \n"
                + "Name: " + this.getName() + "\n"
                + "Description: " + this.getDescription() + "\n"
                + "Value: " + numberFormat.format(getValue()) + "\n"
                + "ISBN - 13: " + this.getIsbn13() + "\n"
                + "ISBN - 10: " + this.getIsbn10() + "\n"
                + "Width: " + this.getWidth() + "\n"
                + "Height: " + this.getHeight() + "\n"
                + "Depth: " + this.getDepth() + "\n"
                + "Weight: " + this.getWeight()+ "\n"
                + "Author Name: " + this.author.getPeopleName() + "\n"
                + "Author Email: " + this.author.getPeopleEmail() + "\n"
                + "Author CPF: " + this.author.getPeopleCpf() + "\n"
                + "________________________________________________________\n");
    }
    
    @Override
    public boolean priceAdjustment(double adjustment) {
        if (adjustment <= 30){
            this.value += this.value * (adjustment/100);
            return true;
        }  
        return false;
    }

    @Override
    public Books searchBook(String bookName, ArrayList<Books> books) {
        return null;
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }
}
