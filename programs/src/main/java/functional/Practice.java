package functional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        //Find the longest String from a sentence
        String s = "Find the longest word in this sentence using streams";
        String longestWord = Arrays.stream(s.split("\\s+")).max((word1,word2)->Integer.compare(word1.length(),word2.length())).get();
        System.out.println(longestWord);

        //Given two list of strings find the intersection of them using stream
        List<String> list1 = Arrays.asList("apple", "banana", "orange", "mango");
        List<String> list2 = Arrays.asList("banana", "grape", "orange", "watermelon");
        List<String> intersection = list1.stream().filter(list2::contains).collect(Collectors.toList());
        System.out.println(intersection);

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000),
                new Employee("Bob", 60000),
                new Employee("Charlie", 55000),
                new Employee("Diana", 65000)
        );

//      double totalSalary = employees.stream().mapToDouble(Employee::getSalary).reduce(0,(a,b)->a+b);
        double totalSalary = employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(totalSalary);

        double avgSalary = employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
        System.out.println(avgSalary);
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}