package myPackage;

import java.io.FileInputStream;
import java.util.Scanner;

public class AnalyticsTUI

    //THIS IS SOME ADDITIONAL TEXT, TO TEST IF GITHUB BRANCHING IS WORKING
    //To create a Git branch, select Git> + New Branch


        /*
         * This builds on Assignment2 (MVP2)
         * Amends Demo switch option in main method
         * See myDemo @line 138
         */

        /*
         * PSEUDOCODE. WHAT DO I WANT THE MAIN METHOD TO DO?!?
         *
         * 1) Print a welcome message to the user
         *
         * 2) Display a menu with 4 options: a) text input, b) read from file, c) demo, d)
         * exit Lab 2, SWITCH STATEMENT
         *
         * 3) After each option the user should be asked to choose again, until they choose
         * to exit LAB 4, WHILE LOOP (BOOLEAN SET TO TRUE)
         *
         * If a), call keyboard class to enter text manually
         * If b), read file content
         * If c), launch the demo programme
         * If d), display a goodbye message and terminate the programme
         */

{
    public static void main(String[] args) throws Exception {

        Scanner menuScanner = new Scanner(System.in);

        // print out a welcome message to the user
        System.out.println("Welcome to the Text Analytics Programme");
        System.out.println();

        // Display a menu with 4 options: a) text input, b) read from file, c) demo, d) exit
        // After each option the user should be asked to choose again, until they choose to exit

        // boolean used to control whether the loop will continue to ask user for input
        // set to true by default. only becomes false if the user wishes to exit the programme

        boolean newInput = true;
        String keyIn = "";
        String inputType = "";
        boolean execute = false;

        // use while loop
        // presents user with options and then performs tasks based on the selected options

        while (newInput) // do while maybe more efficient. get this working first though
        {
            //present user with options

            System.out.println("Please select a menu option to continue");
            System.out.println();
            System.out.println("(a) Enter the text manually");
            System.out.println("(b) Read the text from file");
            System.out.println("(c) Enter Demo mode");
            System.out.println("(d) Exit");

            //get the user's input as the first character from the next line
            //presented to the scanner
            char marcInput = menuScanner.nextLine().charAt(0);

            //switch statement based on the user's input
            switch (marcInput)
            {
                //enter text manually

                case 'a':

                    /*
                     * THINGS TO CHECK W/JASON
                     * 1. Are we able to introduce full character set? Currently only letters
                     * 3. Should we look at JavaFX, to create a GUI?
                     * 4. What would we need to do to make it vertical instead of horizontal?
                     */

                    execute = true;

                    System.out.println("Please enter the word you want to analyse:");
                    keyIn = menuScanner.nextLine();
                    System.out.println();
                    inputType = "Manual";

                    //Keyboard manual = new Keyboard(keyIn);
                    // print out info to user
                    System.out.println("New string added: " + keyIn); //might not need this eventually

                    break;

                //read text from file
                case 'b':

                    /*
                     * CHECK WITH JASON
                     * amended this to offer three files to choose from
                     * is there anyway we could simply this?
                     * used repeat code for scanner line, but i think they're unique as they fetch different files?
                     */

                    execute = true;

                    System.out.println();
                    System.out.println("You selected the read file option");
                    System.out.println();
                    System.out.println("Please select the file required, from the menu below");
                    System.out.println();
                    System.out.println("(a) File 1");
                    System.out.println("(b) File 2");
                    System.out.println("(c) File 3");

                    char readFile = menuScanner.nextLine().charAt(0);

                    switch (readFile) {

                        case 'a':
                            execute = true;

                            Scanner readFile1 = new Scanner(new FileInputStream("file/analysis.txt"));
                            keyIn = "";
                            inputType = "File";

                            while(readFile1.hasNextLine())

                            {
                                keyIn = keyIn + readFile1.nextLine(); //store the file content into variable
                            }
                            break;

                        case 'b':
                            execute = true;

                            Scanner readFile2 = new Scanner(new FileInputStream("file/analysis2.txt"));
                            keyIn = "";
                            inputType = "File";

                            while(readFile2.hasNextLine())
                            {
                                keyIn = keyIn + readFile2.nextLine(); //store the file content into variable
                            }
                            break;

                        case 'c':
                            execute = true;

                            Scanner readFile3 = new Scanner(new FileInputStream("file/analysis3.txt"));
                            keyIn = "";
                            inputType = "File";

                            while(readFile3.hasNextLine())
                            {
                                keyIn = keyIn + readFile3.nextLine(); //store the file content into variable
                            }
                            break;
                    }
                    break;

                case 'c':
                    execute = false;


                    System.out.println();
                    System.out.println("You selected the Demo option");
                    System.out.println();
                    System.out.println("Please select from the menu below");
                    System.out.println();
                    //System.out.println("(a) Key data manually");
                    System.out.println("(a) Use demo file data");
                    System.out.println("(b) Return to main menu");

                    char myDemo = menuScanner.nextLine().charAt(0);

                    switch (myDemo)
                    {
                        case 'a': //demo option. use file input code

                            /*
                             * THINGS TO CHECK W/JASON
                             * 1. What should we include here? Currently a bit dull.
                             *
                             * Add three options: manual, file, return to main
                             *
                             * Read files should allow user to select a file (nested switch)
                             * allow user to enter the file name, no default required
                             * add a try catch for exception if file doesn't exist
                             */

                            execute = true;

                            Scanner user = new Scanner(System.in);
                            //prompt user for file name to read from
                            System.out.println("Please enter the demo filename demofile.txt");
                            String inputFileName = user.nextLine(); //variable to store input file name
                            Scanner input = new Scanner (new FileInputStream("file/" + inputFileName));
                            //reads content in from file

                            //read file in. create new fileinput stream
                            //Scanner demoFile = new Scanner(new FileInputStream("File/demofile.txt"));
                            //declare variable to store file content
                            inputType = "Demo File";
                            keyIn = "";

                            //write a program (while loop) to read in content from file

                            while(input.hasNextLine())
                            {
                                keyIn = keyIn + input.nextLine() + '\n'; //store the file content into variable
                            }

                            System.out.println("Demo file successfully read"); //might not need this eventually

                            break;

                        /*
                        This isn't working quite right
                        It breaks out but then runs line 262
                         */
                        case 'b':
                            execute = false;

                            System.out.println();
                            break; //return to main menu

                        default:
                            System.out.println("Nothing was selected");
                    }

                    break;

                case 'd':
                    execute = false;

                    System.out.println();
                    System.out.println("Thank you for using my Text Analytics Programme. Goodbye!");
                    newInput = false;
                    break;

                // if the user does not select a, b, c or d, print an error message

                default:
                    System.out.println("Sorry, that is not a valid option");
            }

            String summaryText = "";

            switch (inputType)
            {
                case "Manual":
                    summaryText = "text";
                    break;

                case "File":
                    summaryText = "file";
                    break;

                case "Demo File":
                    summaryText = "demo file";
                    break;
            }

            //this is now also runs for main menu exit (213) and demo mode 'return to menu' (213)
            //we don't want to run this, if either myDemo switch b or marcInput switch d are chosen

            //lines 213 & 223

            //do we need an if statement here?...how do we reference switch/nested switch within an if?

            //consider wrapping 296-309 in a method and call the methods from the switch statements
            //rather than having a boolean check run each time


            if(execute) {

                execute = false;

                System.out.println("The analysis for the " + summaryText + " input is shown below");
                System.out.println();

                if(inputType.equals("File") || inputType.equals("Demo File")) {
                    System.out.println("The file contents are: ");
                    System.out.println();
                    System.out.print(keyIn);
                    System.out.println();
                }

                Calculate2 manualKey = new Calculate2(keyIn); //instantiates the object in Calculate2 constructor
                manualKey.xCalculate2(); //calls xCalculate void method, passing the Calculate2 object
                System.out.println();
                System.out.println("The text analysis is now complete.");

                pressAnyKeyToContinue();
            }
        }
        menuScanner.close();
    }

    static private void pressAnyKeyToContinue()
    {
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }
}
