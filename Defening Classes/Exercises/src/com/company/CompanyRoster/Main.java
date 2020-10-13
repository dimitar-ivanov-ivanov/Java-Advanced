package com.company.CompanyRoster;

import com.company.CompanyRoster.Models.Department;
import com.company.CompanyRoster.Models.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int numberOfEmployees = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = getEmployees(scanner, numberOfEmployees);
        printDepartmentWithHighestSalary(departments);
    }

    private static void printDepartmentWithHighestSalary(Map<String, Department> departments) {
        departments
                .entrySet()
                .stream()
                .sorted((d1, d2) -> {
                    Double firstDepartmentAverageSalary = d1.getValue().getAverageSalary();
                    Double secondDepartmentAverageSalary = d2.getValue().getAverageSalary();
                    return Double.compare(secondDepartmentAverageSalary, firstDepartmentAverageSalary);
                })
                .limit(1)
                .forEach(departmentSet -> {
                    Department department = departmentSet.getValue();
                    System.out.println("Highest Average Salary: " + department.getName());
                    department
                            .getEmployees()
                            .stream()
                            .sorted()
                            .forEach(employee -> System.out.println(employee));
                });
    }

    private static Map<String, Department> getEmployees(Scanner scanner, int numberOfEmployees) {
        Map<String, Department> departments = new HashMap<>();

        for (int i = 0; i < numberOfEmployees; i++) {
            String[] args = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .filter(s -> !s.isEmpty())
                    .map(s -> s.trim())
                    .toArray(String[]::new);

            Employee employee = Employee.parseEmployee(args);
            Department department = new Department(employee.getDepartment());

            if (!departments.containsKey(employee.getDepartment())) {
                departments.put(employee.getDepartment(), new Department(employee.getDepartment()));
            }

            departments.get(employee.getDepartment()).addEmployee(employee);
        }

        return departments;
    }
}
