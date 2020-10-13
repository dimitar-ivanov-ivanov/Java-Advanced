package com.company.CompanyRoster.Models;

import java.text.DecimalFormat;

public class Employee implements Comparable<Employee> {
    private static final String MISSING_EMAIL = "n/a";
    private static final int MISSING_AGE = -1;

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = MISSING_EMAIL;
        this.age = MISSING_AGE;
    }

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this(name, salary, position, department);
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department);
        this.email = email;
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department);
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static Employee parseEmployee(String[] args) {
        Employee employee = new Employee(args[0], Double.parseDouble(args[1]), args[2], args[3]);

        if (args.length == 6) {
            employee.setEmail(args[4]);
            employee.setAge(Integer.parseInt(args[5]));
        } else if (args.length == 5) {
            try {
                employee.setAge(Integer.parseInt(args[4]));
            } catch (NumberFormatException e) {
                employee.setEmail(args[4]);
            }
        }

        return employee;
    }


    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return this.name + " " + df.format(this.salary) + " " + this.email + " " + this.age;
    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(other.getSalary(), this.getSalary());
    }
}
