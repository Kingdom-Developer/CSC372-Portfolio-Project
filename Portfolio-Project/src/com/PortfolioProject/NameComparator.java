package com.PortfolioProject;
import java.util.*;

// Comparator class for sorting students by name
public class NameComparator implements Comparator<Student> {

    // Override the compare method
    @Override
    public int compare(Student stu1, Student stu2) {
        // Compare roll numbers from student 1 and student
        return stu1.getName().compareTo(stu2.getName());
    }
}
