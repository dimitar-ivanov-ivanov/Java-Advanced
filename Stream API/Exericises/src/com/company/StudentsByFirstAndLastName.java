package com.company;

import com.company.Classes.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] studentsInput = input.split(" ");
        List<Student> students = new ArrayList<>();

        while (!input.equals("END")) {
            String firstName = studentsInput[0];
            String lastName = studentsInput[1];
            Student student = new Student(firstName, lastName);
            students.add(student);

            input = scanner.nextLine();
            studentsInput = input.split(" ");
        }

        students
                .stream()
                .filter(student -> student.getFirstName().compareTo(student.getLastName()) < 0)
                .forEach(x -> System.out.println(x.getFirstName() + " " + x.getLastName()));
    }
}
