package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("QUOTESAVE");
        System.out.println("by STINJA\n\n");

        // Instantiate file object
        File quoteFile = new File("quotesList.txt");

        // If a file doesn't exist, create it
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

        int menuSelection;
        int quoteIndex;
        do {
            quoteIndex = getLastQuoteIndex(input, quoteFile);
            System.out.println("\n\nTHE CURRENT FILE HAS " + quoteIndex + " QUOTES SAVED.\n\n");

            menuSelection = startMenu(input);
            switch (menuSelection) {
                case 1 -> {
                    System.out.println("YOU SELECTED ADD QUOTE.");
                    addQuote(input, quoteFile, quoteIndex);
                }
                case 2 -> {
                    System.out.println("YOU SELECTED SHOW QUOTE.");
                    showQuote(input, quoteFile);
                }
                case 3 -> {
                    System.out.println("YOU SELECTED EDIT QUOTE.");
                    editQuote(input, quoteFile);
                }
                case 4 -> {
                    System.out.println("YOU SELECTED DELETE QUOTE.");
                    deleteQuote(input, quoteFile);
                }
                case 5 -> {
                    System.out.println("EXITING QUOTESAVE.");
                    exitQuoteSave();
                }
            }
        } while (menuSelection != 5);
    }

    /** --- startMenu -------------------------
     Start menu that runs at the beginning of the program.
     Anytime an action is completed display this menu.
     This should be the only way to exit in program.
     @param menuInput, scanner - take user inputted menu selection
     @return menuSelect, int - int of menu item selected
      * -----------------------------------------  */
    private static int startMenu(Scanner menuInput) {
        // output a bunch of text
        System.out.println("--- MAIN MENU ---");
        System.out.println("1. ADD A QUOTE");
        System.out.println("2. VIEW QUOTE");
        System.out.println("3. EDIT QUOTE");
        System.out.println("4. DELETE QUOTE");
        System.out.println("5. QUIT/EXIT");
        System.out.println("\n\n");
        System.out.print("ENTER A MENU SELECTION: ");

        // grab menu selection from scanner
        int menuSelect = menuInput.nextInt();

        // reset scanner passed in this method
        menuInput.reset();

        // return the selection as an int
        return menuSelect;
    }

    /** --- addQuote --------------------------
     *
     * @param input - descirption
     * @param quoteFile - descirption
     * -----------------------------------------
     */
    private static void addQuote(Scanner input, File quoteFile, int currentIndex) throws IOException {
        Quote newQuote = new Quote();
        input = new Scanner(System.in);

        int qIndex = ++currentIndex;
        System.out.println(qIndex);
        newQuote.setIndex(qIndex);

        String qContent = inputQContent(input);
        newQuote.setContent(qContent);

        String qAuthor = inputQAuthor(input);
        newQuote.setAuthor(qAuthor);

        System.out.println("QUOTE SUCCESSFULLY ADDED.");

        saveQuote(newQuote, quoteFile);
    }

    private static void saveQuote(Quote quote, File quoteFile) throws IOException {
        FileWriter fileWriter = new FileWriter(quoteFile, true);

        // write index
        fileWriter.write("\nQuote #" + quote.getIndex());
        fileWriter.flush();

        // write quote
        fileWriter.write("\n\"" + quote.getContent() + "\"");
        fileWriter.flush();

        // write author, add line after
        fileWriter.write("\nby " + quote.getAuthor() + "\n");
        fileWriter.flush();

        // close filewriter
        fileWriter.close();

        System.out.println("QUOTE SUCCESSFULLY SAVED TO FILE.");
    }

    private static int getLastQuoteIndex(Scanner input, File quoteFile) throws FileNotFoundException {

        input = new Scanner(quoteFile);
        int lastQuoteIndex = 0;

        while (input.hasNextLine()) {
            String string = input.nextLine();
            if (string.startsWith("Quote #")) {
                // get index from string, make int
                lastQuoteIndex = Integer.parseInt(string.substring("Quote #".length()));
            }
        }

        return lastQuoteIndex;
    }

    /** --- inputQContent ------------------------
     *     // TODO set up so user can enter in quote content based on index
     *     // * -- check the index of the quote
     *     // * -- allow user to input content of quote based on index
     *     // * -- save input to variable
     *     // * -- advance to author
     * @param input - descirption
     * @return - descirption
     * -------------------------------------------
     */
    private static String inputQContent(Scanner input) {
        System.out.print("Enter quote content: ");
        String quoteContent = input.nextLine();
        return quoteContent;
    }

    /** --- inputQAuthor -------------------------
     *     // TODO set up so user can enter quote author based on index, if no author default to "unknown"
     *     // * -- check index of the quote
     *     // * -- allow user to input author of quote based on index
     *     // * -- if no input, prompt user 3 times before assigning the string "unknown"
     *     //  * -- save input to variable
     * @param input - descirption
     * @return - descirption
     * -------------------------------------------
     */
    private static String inputQAuthor(Scanner input) {
        System.out.print("Enter quote author: ");
        String quoteAuthor = input.nextLine();
        return quoteAuthor;
    }

    /** --- showQuotes ---------------------------
     *
     * -------------------------------------------
     */
    private static void showQuote(Scanner input, File quoteFile) {
        System.out.println("TODO -- build showQuotes method");
    }

    /** --- editQuotes ---------------------------
     *
     * -------------------------------------------
     */
    private static void editQuote(Scanner input, File quoteFile) {
        int index = 0;
        String content = "";
        String author = "";

        System.out.println("(EDIT) QUOTE INDEX:");
        System.out.println("QUOTE #" + index);
        // display quote to be edited based on given index
        System.out.println("CONTINUE AND EDIT QUOTE?");
        // if y/n or yes,
            // take quote index
            // find quote inside the text file
            // copy line after quote #xxx put in content
            // delete line
            // copy line after previous line put in author
            // delete line
            // call the scanner
            System.out.print("Content: " + content); // allow input using this line
            // take input from scanner and place inside content
            // display content
            // prompt user to continue, if they say no loop back around and redo
            // if yes, do same as above with author
            Quote quote = new Quote(index, content, author);
            // send to
            updateQuote(input, quoteFile, quote);
            System.out.println("QUOTE #X SUCCESSFULLY UPDATED.");
        // else break; to "EDIT A DIFFERENT QUOTE?"
        System.out.println("EDIT A DIFFERENT QUOTE? (Y/N)");
        // if y or yes, go back up to "(EDIT) QUOTE INDEX:"
        // else break; out of this method and back to main menu
    }

    /** --- updateQuote --------------------------
     *
     * -------------------------------------------
     */
    private static void updateQuote(Scanner input, File quoteFile, Quote quote) {
        // grab index
        // search file for "Quote #" + quote.index
        // advance scanner to next line
        // add quote.content then advance to next line
        // add quote.author then advance to next line
        // advance to next line
        // close scanner
    }

    /** --- deleteQuote --------------------------
     *
     * -------------------------------------------
     */
    private static void deleteQuote(Scanner input, File quoteFile) {
        int index = 0;
        System.out.println("(DELETE) QUOTE INDEX:");
        System.out.println("QUOTE #" + index);
        // display quote to be deleted based on given index
        System.out.println("CONTINUE AND DELETE?");
        // if y/n or yes, delete quote
        // take quote index
        // find quote inside the text file
        // delete 4 lines starting with "quote #"
        // else break; to "Delete another quote?"
        System.out.println("QUOTE #X SUCCESSFULLY DELETED.");
        System.out.println("DELETE A QUOTE? (Y/N)");
        // if y or yes, go back up to "QUOTE INDEX:"
        // else break; out of this method and back to main menu
    }

    /** --- exitQuoteSave ------------------------
     *
     * -------------------------------------------
     */
    private static void exitQuoteSave() {
        System.out.println("GOODBYE");
    }
}
