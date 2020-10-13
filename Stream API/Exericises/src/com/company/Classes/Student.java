package com.company.Classes;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private int groupNumber;
    private String email;
    private String phone;
    private String facultyNumber;
    private int[] marks;

    public Student(String firstName, String lastName, int groupNumber) {
        this(firstName, lastName);
        this.groupNumber = groupNumber;
    }

    public Student(String firstName, String lastName, String phone) {
        this(firstName, lastName);
        this.phone = phone;
    }

    public Student(String firstName, String lastName, int[] marks) {
        this(firstName, lastName);
        this.marks = new int[marks.length];
        System.arraycopy(marks, 0, this.marks, 0, marks.length);
    }

    public Student(String facultyNumber, int[] marks) {
        this.facultyNumber = facultyNumber;
        this.marks = new int[marks.length];
        System.arraycopy(marks, 0, this.marks, 0, marks.length);
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}
