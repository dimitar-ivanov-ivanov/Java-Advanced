package com.company;

import com.company.Classes.Student;
import com.company.Classes.StudentSpecialty;

import java.util.*;
import java.util.stream.Collectors;

public class StudentsJoinedToSpecialties {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<StudentSpecialty> specialties = getSpecialties(scanner);
        List<Student> students = getStudents(scanner);
        joinStudentsToSpecialties(students, specialties);
    }

    private static void joinStudentsToSpecialties(List<Student> students, List<StudentSpecialty> specialties) {
        Map<Student, StudentSpecialty> result = students.stream()
                .distinct()
                .filter(student -> specialties.contains(student.getFacultyNumber()))
                .collect(student -> Collectors
                        .toMap(student, specialties.stream()
                                .filter(specialty -> specialty.getFacultyNumber().)
                                .findFirst()
                                .get()));
    }

    private static List<StudentSpecialty> getSpecialties(Scanner scanner) {
        String input = scanner.nextLine();
        String[] studentsInput = input.split(" ");
        List<StudentSpecialty> specialties = new ArrayList<>();

        while (!input.equals("Students:")) {
            String specialtyName = String.join(" ", Arrays.stream(studentsInput).limit(studentsInput.length - 1).collect(Collectors.toList()));
            String facultyNumber = studentsInput[studentsInput.length - 1];

            StudentSpecialty specialty = new StudentSpecialty(specialtyName, facultyNumber);
            specialties.add(specialty);

            input = scanner.nextLine();
            studentsInput = input.split(" ");
        }

        return specialties;
    }

    private static List<Student> getStudents(Scanner scanner) {
        String input = scanner.nextLine();
        String[] studentsInput = input.split(" ");
        List<Student> students = new ArrayList<>();

        while (!input.equals("END")) {
            String facultyNumber = studentsInput[0];
            String firstName = studentsInput[0];
            String lastName = studentsInput[1];

            Student student = new Student(firstName, lastName, facultyNumber);
            students.add(student);

            input = scanner.nextLine();
            studentsInput = input.split(" ");
        }

        return students;
    }
}

