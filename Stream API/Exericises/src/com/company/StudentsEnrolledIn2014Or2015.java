package com.company;

import com.company.Classes.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentsEnrolledIn2014Or2015 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] studentsInput = input.split(" ");
        List<Student> students = new ArrayList<>();
        String regexRightYear = "[0-9]{4}(14|15)";

        while (!input.equals("END")) {
            String facultyNumber = studentsInput[0];
            int[] marks = Arrays.stream(studentsInput)
                    .skip(1)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (studentWasEnrolledIn2014Or2015(facultyNumber, regexRightYear)) {
                Student student = new Student(facultyNumber, marks);
                students.add(student);
            }

            input = scanner.nextLine();
            studentsInput = input.split(" ");
        }

        students.stream()
                .forEach(student -> {
                    Arrays.stream(student.getMarks()).forEach(mark -> {
                        System.out.print(mark + " ");
                    });
                    System.out.println();
                });

    }

    private static boolean studentWasEnrolledIn2014Or2015(String facultyNumber, String regexRightYear) {
        Pattern rightYearPattern = Pattern.compile(regexRightYear);
        Matcher rightYearMatcher = rightYearPattern.matcher(facultyNumber);

        if (rightYearMatcher.find()) {
            int year = Integer.parseInt(rightYearMatcher.group(1));
            if (year == 14 || year == 15) {
                return true;
            }
        }

        return false;
    }
}
