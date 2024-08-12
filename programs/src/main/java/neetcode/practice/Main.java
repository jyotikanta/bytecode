package neetcode.practice;

import java.util.*;

class Employee implements Comparable<Employee> {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public int compareTo(Employee other) {
        int nameComparison = this.name.compareTo(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        } else {
            return this.department.compareTo(other.department);
        }
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', department='" + department + "'}";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "Engineering"));
        employees.add(new Employee("Alice", "Engineering"));
        employees.add(new Employee("David", "HR"));
        employees.add(new Employee("Bob", "HR"));

        Collections.sort(employees);

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
