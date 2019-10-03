package br.ufpr.books;

import br.ufpr.people.Author;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author ulisses
 */
public class PrintedBooks extends Books{
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
    
    public PrintedBooks searchPrintedBook(String bookName, ArrayList<PrintedBooks> pB){
        for (PrintedBooks pBs : pB){
            String x = pBs.getName();
            if (x.equalsIgnoreCase(bookName)){
                return pBs;
            }
        }
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
}
