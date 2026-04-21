package com.amigoscode._7_streams._7_statistics;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Exercise: Count, Min, and Max
 *
 * Learn to use counting operations and find minimum/maximum elements
 * using both stream methods and Collectors.
 */
public class CountMinMax {

    record Employee(String name, String department, double salary) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "Engineering", 95000),
                new Employee("Bob", "Engineering", 88000),
                new Employee("Charlie", "Marketing", 72000),
                new Employee("Diana", "Marketing", 78000),
                new Employee("Eve", "Sales", 68000),
                new Employee("Frank", "Engineering", 102000),
                new Employee("Grace", "Sales", 71000),
                new Employee("Henry", "Marketing", 82000)
        );

        // TODO: 1 - Count the number of employees with salary greater than 80000
        //           Use filter + count() and print the result
        System.out.println("TODO: 1 ");
        long salaryGreaterThan80000 = employees.stream().filter(employee -> employee.salary > 80000).count();
        System.out.println(salaryGreaterThan80000);
        System.out.println();


        // TODO: 2 - Find the employee with the lowest salary
        //           Use min() with Comparator.comparingDouble(Employee::salary)
        //           Print the employee's name and salary
        System.out.println("TODO: 2 ");
        Employee lowestSalary = employees.stream().min(Comparator.comparingDouble(Employee::salary)).get();
        System.out.println(lowestSalary.name() + ", " + lowestSalary.salary());
        System.out.println();


        // TODO: 3 - Find the employee with the highest salary
        //           Use max() with an appropriate comparator
        //           Print the employee's name and salary
        System.out.println("TODO: 3 ");
        Employee maxSalary = employees.stream().max(Comparator.comparingDouble(Employee::salary)).get();
        System.out.println(maxSalary.name() + ", " + maxSalary.salary());
        System.out.println();


        // TODO: 4 - Use the Collectors.counting() collector to count all employees
        //           Print the result
        System.out.println("TODO: 4 ");
        long sumEmployees = employees.stream().collect(Collectors.counting());
        System.out.println(sumEmployees);
        System.out.println();

        // TODO: 5 - Combine count with groupingBy: count employees per department
        //           Use Collectors.groupingBy with Collectors.counting() as downstream
        //           Print each department and its count
        System.out.println("TODO: 5 ");
        Map<String,Long> sortedByGroup =
                employees
                        .stream()
                        .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));
        System.out.println(sortedByGroup);
        System.out.println();

        // TODO: 6 - Use Collectors.minBy and Collectors.maxBy to find the lowest
        //           and highest paid employees
        //           Print both results
        System.out.println("TODO: 6 ");
        Optional<Employee> minEmployee = employees.stream().collect(Collectors.minBy(Comparator.comparingDouble(Employee::salary)));
        Optional<Employee> maxSalaryEmployee = employees.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::salary)));
        System.out.println("Employee with min Salary: " + minEmployee);
        System.out.println("Employee with max Salary: " + maxSalaryEmployee);
    }
}
