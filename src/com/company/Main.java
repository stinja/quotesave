package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        // TODO figure out if file stuff can go in its own method
        // Instantiate file object
        File quoteFile = new File("quotesList.txt");

        // If a file doesn't exist, create it
        // TODO fix the stupid error on this one
        if (!quoteFile.exists()) {
            try {
                quoteFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter fileWriter = new FileWriter(quoteFile, true);
        Scanner input = new Scanner(System.in);
        Quote quote = new Quote();

        // TODO call startMenu and do something with the return int
        //  consider putting this switch statement in the startMenu method
        int menuSelection = startMenu(input);
        switch (menuSelection) {
            case 1 -> addQuote(input, quoteFile);
            case 2 -> showQuotes();
            case 3 -> editQuote();
            case 4 -> deleteQuote();
            case 5 -> exitQuoteSave();
        }
    }

    // FUNCTIONS/METHODS
    /*

      createQuote - create a single quote based on user input
      deleteQuote - given the index of the quote, delete from text file
      editQuote - given the index, grab quote and allow user to edit


      addQuoteToTextFile - append quote to text file
      deleteQuoteFromTextFile
      readQuoteFromTextFile - read a single quote from text based on index
      readAllQuotesFromTextFile - read all quotes from text
      printQuoteToScreen - print read quote to screen
      printAllQuotesToScreen - print read quotes to screen


      getIndex
      getQuoteContent
      getQuoteAuthor
      getDateAdded

      setIndex
      setQuoteContent
      setDateAdded

     */

    /** --- startMenu -------------------------
     Start menu that runs at the beginning of the program.
     Anytime an action is completed display this menu.
     This should be the only way to exit in program.
     @param menuInput, scanner - take user inputted menu selection
     @return menuSelect, int - int of menu item selected
      * -----------------------------------------  */
    private static int startMenu(Scanner menuInput) {
        // output a bunch of text
        System.out.println("QUOTESAVE");
        System.out.println("by STINJA\n\n");
        System.out.println("1. ADD A QUOTE");
        System.out.println("2. VIEW QUOTES");
        System.out.println("3. EDIT QUOTES");
        System.out.println("4. DELETE QUOTES");
        System.out.println("5. QUIT/EXIT");
        System.out.println("\n\nWhat would you like to do?");
        System.out.print("Please enter a number: ");

        // grab menu selection from scanner
        // TODO add some handling if user enters !isInt
        int menuSelect = menuInput.nextInt();

        // reset scanner passed in this method
        menuInput.reset();

        // print out user's selection
        // TODO change so it prints out the text associated with the menu item
        //  use a switch statement for this
        System.out.println("You selected " + menuSelect + ".");

        // return the selection as an int
        return menuSelect;
    }

    /** --- addQuote --------------------------
     *
     * @param input - descirption
     * @param quoteFile - descirption
     * -----------------------------------------
     */
    private static void addQuote(Scanner input, File quoteFile) {
        Quote newQuote = new Quote(); // TODO fix error here

        int qIndex = determineNextIndex(input);
        String qContent = inputQContent(input);
        String qAuthor = inputQAuthor(input);

        newQuote.setIndex(qIndex);
        newQuote.setContent(qContent);
        newQuote.setAuthor(qAuthor);
    }

    // TODO set up so index is created automatically
    // * -- check index of previous quote in text file
    // * -- if no quote exists, index is 1
    // * -- if quote exists, take index and increment by 1
    // * -- take that value and assign to qIndex
    /** --- determineNextIndex -------------------
     *
     * @param input - descirption
     * @return - descirption
     * -------------------------------------------
     */
    private static int determineNextIndex(Scanner input) {
        System.out.print("[TEMP] Enter int for index: ");
        int indexNumber = input.nextInt();
        input.nextLine(); // advance scanner
        return indexNumber;
    }

    // TODO set up so user can enter in quote content based on index
    // * -- check the index of the quote
    // * -- allow user to input content of quote based on index
    // * -- save input to variable
    // * -- advance to author
    /** --- inputQContent ------------------------
     *
     * @param input - descirption
     * @return - descirption
     * -------------------------------------------
     */
    private static String inputQContent(Scanner input) {
        System.out.print("Enter quote content: ");
        String quoteContent = input.nextLine();
        return quoteContent;
    }

    // TODO set up so user can enter quote author based on index, if no author default to "unknown"
    // * -- check index of the quote
    // * -- allow user to input author of quote based on index
    // * -- if no input, prompt user 3 times before assigning the string "unknown"
    //  * -- save input to variable
    /** --- inputQAuthor -------------------------
     *
     * @param input - descirption
     * @return - descirption
     * -------------------------------------------
     */
    private static String inputQAuthor(Scanner input) {
        System.out.print("Enter quote content: ");
        String quoteAuthor = input.nextLine();
        return quoteAuthor;
    }

    /** --- showQuotes ---------------------------
     *
     * -------------------------------------------
     */
    private static void showQuotes() {
        System.out.println("TODO -- build showQuotes method");
    }

    /** --- editQuotes ---------------------------
     *
     * -------------------------------------------
     */
    private static void editQuote() {
        System.out.println("TODO -- build editQuote method");
    }

    /** --- deleteQuote --------------------------
     *
     * -------------------------------------------
     */
    private static void deleteQuote() {
        System.out.println("TODO -- build deleteQuote method");
    }

    /** --- exitQuoteSave ------------------------
     *
     * -------------------------------------------
     */
    private static void exitQuoteSave() {
        System.out.println("TODO -- create the exitQuoteSave method");
    }
}
