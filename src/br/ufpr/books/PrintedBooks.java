package br.ufpr.books;

import br.ufpr.people.Author;
import java.text.NumberFormat;
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
    
    @Override
    public String showInfo(){
        
        Locale ptBR = new Locale("pt", "BR");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(ptBR);
        
        return("Name: " + this.getName() + "\n"
        + "Description: " + this.getDescription() + "\n"
        + "Value: " + numberFormat.format(getValue()) + "\n"
        + "ISBN - 13: " + this.getIsbn13() + "\n"
        + "ISBN - 10: " + this.getIsbn10() + "\n"
        + "Width: " + this.getWidth() + "\n"
        + "Height: " + this.getHeight() + "\n"
        + "Depth: " + this.getDepth() + "\n"
        + "Weight: " + this.getWeight()+ "\n"
        + "Author Name: " + this.author.getPeapleName() + "\n"
        + "Author Email: " + this.author.getPeapleEmail() + "\n"
        + "Author CPF: " + this.author.getPeapleCpf() + "\n");
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
