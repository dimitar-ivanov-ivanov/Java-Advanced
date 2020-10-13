package com.company;

import com.company.Classes.Student;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class StudentsGroupedByGroup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] studentsInput = input.split(" ");
        List<Student> students = new ArrayList<>();

        while (!input.equals("END")) {
            String firstName = studentsInput[0];
            String lastName = studentsInput[1];
            Integer group = Integer.parseInt(studentsInput[2]);

            Student student = new Student(firstName, lastName, group);
            students.add(student);

            input = scanner.nextLine();
            studentsInput = input.split(" ");
        }

        Map<Integer, List<Student>> postsPerType = students.stream()
                .collect(groupingBy(Student::getGroupNumber));

        postsPerType.entrySet().forEach((group) -> {
            System.out.print(group.getKey() + " - ");
            for (int i = 0; i < group.getValue().size(); i++) {
                Student student = group.getValue().get(i);
                System.out.print(student.getFirstName() + " " + student.getLastName());
                if (i != group.getValue().size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        });
    }
}
