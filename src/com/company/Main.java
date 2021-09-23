package com.company;

/** Classes **/
import com.company.Quote;

/** Java Library Imports **/
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    /** FUNCTIONS/METHODS
     *
     * createQuote - create a single quote based on user input
     * deleteQuote - given the index of the quote, delete from text file
     * editQuote - given the index, grab quote and allow user to edit
     *
     *
     * addQuoteToTextFile - append quote to text file
     * deleteQuoteFromTextFile
     * readQuoteFromTextFile - read a single quote from text based on index
     * readAllQuotesFromTextFile - read all quotes from text
     * printQuoteToScreen - print read quote to screen
     * printAllQuotesToScreen - print read quotes to screen
     *
     *
     * getIndex
     * getQuoteContent
     * getQuoteAuthor
     * getDateAdded
     *
     * setIndex
     * setQuoteContent
     * setDateAdded
     *
     */

    public static void main(String[] args) {

        /** Objects **/
        Scanner input = new Scanner(System.in);
        Quote quote = new Quote();


        File file = new File("quotesList.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //quote.setIndex(qIndex);
        // TODO set up so index is created automatically

        //quote.setContent(qContent);
        // TODO set up so user can enter in quote content

        //quote.setAuthor(qAuthor);
        // TODO set up so user can enter quote author, if no author default to "unknown"
    }
}
