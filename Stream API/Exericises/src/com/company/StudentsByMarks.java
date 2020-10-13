package com.company;

import com.company.Classes.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class StudentsByMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] studentsInput = input.split(" ");
        List<Student> students = new ArrayList<>();

        while (!input.equals("END")) {
            String firstName = studentsInput[0];
            String lastName = studentsInput[1];
            int[] marks = Arrays.stream(studentsInput)
                    .skip(2)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Student student = new Student(firstName, lastName, marks);
            students.add(student);

            input = scanner.nextLine();
            studentsInput = input.split(" ");
        }

        getExcellentStudents(students);
        getWeakStudents(students);
    }

    private static void getWeakStudents(List<Student> students) {
        students
                .stream()
                .filter(student -> Arrays.stream(student.getMarks()).filter(mark -> mark <= 3).count() >= 2)
                .forEach(x -> System.out.println(x.getFirstName() + " " + x.getLastName()));
    }

    private static void getExcellentStudents(List<Student> students) {
        students
                .stream()
                .filter(student -> Arrays.stream(student.getMarks()).anyMatch(x -> x == 6))
                .forEach(x -> System.out.println(x.getFirstName() + " " + x.getLastName()));
    }
}
