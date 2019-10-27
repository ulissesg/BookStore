/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.books;

import br.ufpr.people.Author;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author ulisses
 */
public class EBooks implements Books {
    
    private String name;
    private String description;
    private double value;
    private String isbn13;
    private String isbn10;
    public Author author = new Author();
    private String asin;
    private String format;
    private boolean vocabularyTips;
    private double fileSize;
    
    public EBooks(){
        this.asin = "xxxxxxxxxx";
    }
    
    public EBooks(Author author){
        this.asin = "xxxxxxxxxx";
        this.author = author;
    }
    
    public EBooks(String name, String description, double value, String isbn13, String isbn10, 
            String asin, String format, boolean vocabularyTips, double filesize, Author author){
        this.name = name;
        this.description = description;
        this.value = value;
        this.isbn13 = isbn13;
        this.isbn10 = isbn10;
        this.asin = asin;
        this.format = format;
        this.vocabularyTips = vocabularyTips;
        this.fileSize = filesize;
        this.author = author;
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
    public String showInfo(){
        
        Locale ptBR = new Locale("pt", "BR");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(ptBR);
        
        return("\n______________________________________________________\n"
                + "Type: E-book \n"
                + "Name: " + this.getName() + "\n"
                + "Description: " + this.getDescription() + "\n"
                + "Value: " + numberFormat.format(getValue()) + "\n"
                + "ASIN: " + this.getAsin() + "\n"
                + "ISBN - 13: " + this.getIsbn13() + "\n"
                + "ISBN - 10: " + this.getIsbn10() + "\n"
                + "Format: " + this.getFormat() + "\n"
                + "Vocabulary Tips: " + this.isVocabularyTips() + "\n"
                + "File Size: " + this.getFileSize() + "\n"
                + "Author Name: " + this.author.getPeopleName() + "\n"
                + "Author Email: " + this.author.getPeopleEmail() + "\n"
                + "Author CPF: " + this.author.getPeopleCpf() + "\n"
                + "________________________________________________________\n");
    }
    
    @Override
    public Books searchBook(String bookName, ArrayList<Books> books) {
        for (Books book : books){
            if (book.getName().equalsIgnoreCase(bookName)){
                return book;
            }
        }
        return null;
    }


    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public boolean isVocabularyTips() {
        return vocabularyTips;
    }

    public void setVocabularyTips(boolean vocabularyTips) {
        this.vocabularyTips = vocabularyTips;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

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
