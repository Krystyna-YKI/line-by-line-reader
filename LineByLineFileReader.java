/**
 * title: LineByLineFileReader.java
 * description: Assignment 3 - Problem 2
 * date: June 12, 2024
 * @author Krystyna Chernykh
 * @version 1.0
 * @copyright 2001-2024 Krystyna Chernykh
 */
/**
 * DOCUMENTATION...
 */
/**                                                                               
 
 <H1>LineByLineFileReader</H1>
 
 <H3>Purpose and Description</H3>
 
 <P>
 The LineByLineFileReader program reads the contents of a text file and displays each line one at a time, waiting for the user to press the <Enter> key before displaying the next line. 
 This interaction allows the user to read through the file at their own pace.
 </P>

 <H3>
 Special instructions to compile and execute the program:
 </H3>
 <P>
 Save the code in a file named 'LineByLineFileReader.java'.
 Open a terminal or command prompt.
 Navigate to the directory where 'LineByLineFileReader.java' is saved.
 Compile the program using the command: 'javac LineByLineFileReader.java'
 Execute the program using the command: 'java LineByLineFileReader'
 </P>
 
<H3>Class</H3>

<P>
public class LineByLineFileReader
Main class that contains the program logic.
</P>

<H3>LineByLineFileReader Methods</H3>

<P>
main(String[] args): Main method where the program execution begins.
</P>

<H3>LineByLineFileReader Instance Variables</H3>

<P>
scanner: Scanner object to read user input from the console.
fileName: String variable to store the name of the input file.
line: String variable to hold each line read from the file.
</P>

<H3>LineByLineFileReader Constructors</H3>

<P>
None
</P>

/**
<H3>Test Plan</H3>

1. Valid File with Multiple Lines:

Step 1: Run the program.
Step 2: Enter the name of the valid file (excerpt.txt).

INPUT:
excerpt.txt

EXPECTED:
The program should display the first line of the file.
When Enter is pressed, the next line should appear.
So, the program should display all lines one by one and exit after the last line.

ACTUAL:
The console prints the results as expected and exits once all lines have been printed.

2. File Not Found:

Step 1: Run the program.
Step 2: Enter the name of a non-existent file (nonexistent.txt).

INPUT:
nonexistent.txt

EXPECTED:
The program should print an error message indicating that the file cannot be found and exit without displaying any lines.

ACTUAL:
The program prints the result as expected saying "The system cannot find the file specified", no lines were displayed as expected.

Test Case 3: Empty File:

Step 1: Create an empty text file named empty.txt.
Step 2: Run the program.
Step 3: Enter the name of the empty file (empty.txt).

INPUT:
empty.txt

EXPECTED:
The program should not display any lines and should exit immediately.

ACTUAL:
The program didn't display any lines as expected.

Test Case 4: Large File:

Step 1: Create a large text file named large.txt with a large number of lines.
Step 2: Run the program.
Step 3: Enter the name of the large file (large.txt).

INPUT:
large.txt

EXPECTED:
The program should display the lines one by one, waiting for <Enter> after each line. Ensure that performance remains acceptable and all lines are displayed correctly.

ACTUAL:
The program executes line by line as expected.

Test Case 5: File with Special Characters:

Step 1: Create a text file named specialChars.txt containing lines with special characters.
Step 2: Run the program.
Step 3: Enter the name of the file (specialChars.txt).

INPUT:
specialChars.txt

EXPECTED:
The program should correctly display lines with special characters without any issues.

ACTUAL:
The program correctly displays lines with special characters without any issues.

/**
 * CODE...
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineByLineFileReader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Prompt the user to enter the name of the input file
            System.out.print("Enter the name of the input file (or type 'exit' to quit): ");
            String fileName = scanner.nextLine();  // Read the file name entered by the user

            if (fileName.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program.");
                break;  // Exit the loop and end the program
            }

            // Try-with-resources to ensure the BufferedReader is closed automatically
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;  // Variable to hold each line read from the file
                // Read the file line by line
                while ((line = reader.readLine()) != null) {
                    // Print the current line
                    System.out.println(line);
                    
                    // Wait for the user to press <Enter> before displaying the next line
                    System.out.println("Press <Enter> to display the next line...");
                    scanner.nextLine();
                }
            } catch (IOException e) {
                // Handle any IO exceptions that occur while reading the file
                System.out.println("An error occurred while reading the file: " + e.getMessage());
            }
        }

        scanner.close(); // Close the Scanner object to free up resources
    }
}


