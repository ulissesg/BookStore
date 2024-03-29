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
public class EBooks extends Books {
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
    
    @Override
    public String showInfo(){
        
        Locale ptBR = new Locale("pt", "BR");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(ptBR);
        
        return("\n______________________________________________________\n"
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
    
    public EBooks searchEbook(String bookName, ArrayList<EBooks> ebooks){
        for (EBooks ebook : ebooks){
            String x = ebook.getName();
            if (x.equalsIgnoreCase(bookName)){
                return ebook;
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

   
}
