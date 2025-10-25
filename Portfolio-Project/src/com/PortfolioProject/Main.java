package com.PortfolioProject;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {
    // Create static Scanner object
    public static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize LinkedList
        List<Student> studentList = new LinkedList<>();
        // Declare ListIterator for studentList
        ListIterator<Student> listIterator;
        // Declare variables to be used
        Student student;
        String userSelection;
        String userInputName;
        String userInputAddress;
        double userInputGpa;

        // Prompt user for selection
        System.out.print("Press \"q\" to quit or enter any other value to add student to the list: ");
        userSelection = getUserString();

        // While loop to retrieve userSelection
        while (!userSelection.equals("q")) {
            // Get user input values for student's data
            System.out.print("Enter the student's name: ");
            userInputName = getUserString();
            System.out.print("Enter the student's address: ");
            userInputAddress = getUserString();
            userInputGpa = getUserGpa();

            // Create and add new student to the studentList
            studentList.add(new Student(userInputName, userInputAddress, userInputGpa));

            // Reprompt user for selection
            System.out.print("Press \"q\" to quit or enter any other value to add student to the list: ");
            userSelection = getUserString();
        }

        // Sort in studentList by name in ascending order using a NameComparator object
        studentList.sort(new NameComparator());

        // Initialize ListIterator for studentList
        listIterator = studentList.listIterator();

        // While loop to iterate through LinkedList of students
        while (listIterator.hasNext()) {
            // Store next Student object to temporary variable
            student = listIterator.next();

            // Try-catch block to try writing dateTimeField to log.txt and handle exceptions
            try {
                Files.writeString(Path.of("student_list.txt"), student.toString() + "\n \n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                // Print message to indicate if an error occurred while attempting to write to file
                System.out.println("Error writing to file: " + e.getMessage());

                // Return to avoid last section of code from executing
                return;
            }
        }

        // Determine which feedback statement to use
        if (studentList.isEmpty()) {
            System.out.println("Goodbye!");
        }
        else {
            System.out.println("Successfully wrote students' information to file. Goodbye!");
        }
    }

    // Method to retrieve valid user input for GPA
    public static double getUserGpa() {
        // Declare variable to store valid double
        double gpaValue;

        // Prompt User for input
        System.out.print("Please enter a GPA between 0.0 and 4.0: ");
        while (!scnr.hasNextDouble()) {
            System.out.print("Incorrect entry, please try again: ");
            // Clear invalid input
            scnr.next();
        }

        // Store valid double to variable
        gpaValue = scnr.nextDouble();
        scnr.nextLine();

        // Validate that user input is between 0.0 and 4.0
        while (gpaValue < 0.0 || gpaValue > 4.0) {
            System.out.println("GPA is out of range, please enter a value between 0.0 and 4.0: ");
            while (!scnr.hasNextDouble()) {
                System.out.print("Incorrect entry, please try again: ");
                scnr.next();
            }
            gpaValue = scnr.nextDouble();
            scnr.nextLine();
        }

        // Return valid double
        return gpaValue;
    }

    // Method to retrieve valid user string
    public static String getUserString() {
        // Variable to hold user input
        String input;

        // Keep prompting user for input if their input is empty
        while (true) {
            input = scnr.nextLine();

            // Check if user input is empty
            if (!input.trim().isEmpty()) {
                return input;
            }
            System.out.print("Field cannot be empty, please try again: ");
        }
    }
}