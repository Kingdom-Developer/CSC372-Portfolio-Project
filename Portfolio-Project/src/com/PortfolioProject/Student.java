package com.PortfolioProject;

// Class to hold student information
public class Student {
    // Declare private attributes
    private String name;
    private String address;
    private double Gpa;

    // Parameterized constructor
    public Student(String name, String address, double Gpa) {
        // Initialize private attributes
        this.name = name;
        this.address = address;
        this.Gpa = Gpa;
    }

    // Getter and setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter methods for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and setter methods for GPA
    public double getGpa() {
        return Gpa;
    }

    public void setGpa(double gpa) {
        Gpa = gpa;
    }
}