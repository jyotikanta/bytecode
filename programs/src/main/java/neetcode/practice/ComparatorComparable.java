package neetcode.practice;

import java.util.*;

class Student{
    String name;
    Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ComparatorComparable {
    public static void main(String[] args) {
        //Comparator Example
        Student s1 = new Student("Alice", 23);
        Student s2 = new Student("Bob", 21);
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);

//        Collections.sort(students, new Comparator<Student>(){
//            @Override
//            public int compare(Student s1, Student s2){
//                return s1.age.compareTo(s2.age);
//            }
//        });


        Collections.sort(students, (student1, student2) -> student1.age.compareTo(student2.age));
        students.stream().forEach(System.out::println);

        //Comparable Example
        Teacher t1 = new Teacher("John", 45);
        Teacher t2 = new Teacher("Cena", 43);
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(t1);
        teachers.add(t2);
        Collections.sort(teachers);
        teachers.stream().forEach(System.out::println);
    }

    private static class Teacher implements Comparable<Teacher> {
        String name;
        Integer age;

        public Teacher(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Teacher{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public int compareTo(Teacher o) {
            return this.age.compareTo(o.age);
        }
    }
}
