package com.company;

import com.company.Classes.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortStudents {
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
                .sorted((firstStudent, secondStudent) -> {
                    int lastNameAscending = firstStudent.getLastName().compareTo(secondStudent.getLastName());
                    int firstNameDescending = secondStudent.getFirstName().compareTo(firstStudent.getFirstName());
                    if (lastNameAscending == 0) {
                        return firstNameDescending;
                    }
                    return lastNameAscending;
                })
                .forEach(x -> System.out.println(x.getFirstName() + " " + x.getLastName()));
    }
}
