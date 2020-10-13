package com.company.CompanyRoster.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public double getAverageSalary() {
        if (employees.size() == 0) {
            return 0;
        }

        OptionalDouble average = employees.stream()
                .map(e -> e.getSalary())
                .mapToDouble(Double::doubleValue)
                .average();

        return average.getAsDouble();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
}
