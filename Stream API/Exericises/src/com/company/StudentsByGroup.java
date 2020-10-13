package com.company;

import com.company.Classes.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentsByGroup {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] studentsInput = input.split(" ");
        List<Student> students = new ArrayList<>();

        while (!input.equals("END")) {
            String firstName = studentsInput[0];
            String lastName = studentsInput[1];
            int groupNumber = Integer.parseInt(studentsInput[2]);
            Student student = new Student(firstName, lastName, groupNumber);
            students.add(student);

            input = scanner.nextLine();
            studentsInput = input.split(" ");
        }

        students.sort(Comparator.comparing(Student::getFirstName));
        students
                .stream().filter(student -> student.getGroupNumber() == 2)
                .forEach(x -> System.out.println(x.getFirstName() + " " + x.getLastName()));
    }
}

