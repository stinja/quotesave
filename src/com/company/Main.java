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

        // testing new method area
        getLastQuoteIndex(input, quoteFile);
        // testing new method area

        // TODO call startMenu and do something with the return int
        //  consider putting this switch statement in the startMenu method
        int menuSelection;
        do {
            menuSelection = startMenu(input);
            switch (menuSelection) {
                case 1 -> {
                    System.out.println("YOU SELECTED ADD QUOTE.");
                    addQuote(input, quoteFile);
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
    private static void addQuote(Scanner input, File quoteFile) throws IOException {
        Quote newQuote = new Quote();

        int qIndex = determineNextIndex(input);
        String qContent = inputQContent(input);
        String qAuthor = inputQAuthor(input);

        newQuote.setIndex(qIndex);
        newQuote.setContent(qContent);
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

    /** --- determineNextIndex -------------------
     *     // TODO set up so index is created automatically
     *     // * -- check index of previous quote in text file
     *     // * -- if no quote exists, index is 1
     *     // * -- if quote exists, take index and increment by 1
     *     // * -- take that value and assign to qIndex
     * @param input - descirption
     * @return - descirption
     * -------------------------------------------
     */
    private static int determineNextIndex(Scanner input) {

        // parse file
        // grab index of last quote in file (prevIndex)
        // int prevIndex = 0;

        // create indexNumber, assign prevIndex++
        // int nextIndex = prevIndex++;


        System.out.print("[TEMP] Enter int for index: ");
        int nextIndex = input.nextInt();
        input.nextLine(); // advance scanner


        return nextIndex;
    }

    private static int getLastQuoteIndex(Scanner input, File quoteFile) throws FileNotFoundException {

        input = new Scanner(quoteFile);
        int lastQuoteIndex = 0;

        while (input.hasNextLine()) {
            String string = input.nextLine();
            System.out.println(string);
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
        System.out.println("TODO -- build editQuote method");
    }

    /** --- deleteQuote --------------------------
     *
     * -------------------------------------------
     */
    private static void deleteQuote(Scanner input, File quoteFile) {
        System.out.println("TODO -- build deleteQuote method");
    }

    /** --- exitQuoteSave ------------------------
     *
     * -------------------------------------------
     */
    private static void exitQuoteSave() {
        System.out.println("GOODBYE");
    }
}
