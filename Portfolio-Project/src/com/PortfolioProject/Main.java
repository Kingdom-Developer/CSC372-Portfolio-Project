package com.PortfolioProject;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        // Initialize LinkedList
        List<Student> studentList = new LinkedList<Student>();
        // Declare ListIterator for studentList
        ListIterator<Student> listIterator;
        // Declare temporary Student object
        Student student;

        // Test code to confirm functionality of Student class and LinkedList
        Student stu1 = new Student("Nolan", "123 Main St.", 3.4);
        Student stu2 = new Student("James", "321 West St.", 3.6);
        studentList.add(stu1);
        studentList.add(stu2);

        // Initialize ListIterator for studentList
        listIterator = studentList.listIterator();

        // While loop to iterate through LinkedList of students
        while (listIterator.hasNext()) {
            student = listIterator.next();
            System.out.println("Student Name: " + student.getName() + "\n" +
                               "Student Address: " + student.getAddress() + "\n" +
                               "Student GPA: " + student.getGpa() + "\n");
        }
    }
}
