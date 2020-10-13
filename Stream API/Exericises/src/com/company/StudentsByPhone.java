package com.company;

import com.company.Classes.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentsByPhone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] studentsInput = input.split(" ");
        List<Student> students = new ArrayList<>();
        String regexPhone = "(02|\\+3592)\\d+";

        while (!input.equals("END")) {
            String firstName = studentsInput[0];
            String lastName = studentsInput[1];
            String phone = studentsInput[2];

            if (phoneNumberMatchesPattern(phone, regexPhone)) {
                Student student = new Student(firstName, lastName, phone);
                students.add(student);
            }

            input = scanner.nextLine();
            studentsInput = input.split(" ");
        }

        students
                .stream()
                .forEach(x -> System.out.println(x.getFirstName() + " " + x.getLastName()));
    }

    private static boolean phoneNumberMatchesPattern(String phone, String regexPhone) {
        Pattern pattern = Pattern.compile(regexPhone);
        Matcher phoneMatcher = pattern.matcher(phone);

        while (phoneMatcher.find()) {
            String startOfPhoneString = phoneMatcher.group(1);
            if (startOfPhoneString.equals("02") || startOfPhoneString.equals("+3592")) {
                return true;
            }
        }

        return false;
    }
}
