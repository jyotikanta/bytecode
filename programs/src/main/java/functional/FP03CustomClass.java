package functional;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03CustomClass {

    public static void main(String[] args) {
        List<Course> courses = getCourseList();
//        int sum= courses.stream().distinct().reduce(0,);
//        System.out.println(sum);
        Predicate<Course> coursesWithReviewGreaterThan95 = course -> course.getReviewScore() > 95;
        Predicate<Course> coursesWithReviewGreaterThan90 = course -> course.getReviewScore() > 90;
        Predicate<Course> coursesWithReviewLessThan90 = course -> course.getReviewScore() < 90;
        Predicate<Course> coursesWithMoreThan20KStudents = course -> course.getNoOfStudents() > 20000;
        courses.stream().filter(coursesWithMoreThan20KStudents).forEach(course-> System.out.println(course.getName()));
        System.out.println(courses.stream().allMatch(coursesWithReviewGreaterThan95));
        System.out.println(courses.stream().allMatch(coursesWithReviewGreaterThan90));
        System.out.println(courses.stream().noneMatch(coursesWithReviewLessThan90));
        System.out.println(courses.stream().anyMatch(coursesWithReviewGreaterThan90));


        Comparator<Course> courseWithMostStudentsIncreasingOrder = Comparator.comparing(Course::getNoOfStudents);
        Comparator<Course> courseComparator = Comparator.comparing(Course::getReviewScore);

        System.out.println(courses.stream().sorted(courseComparator).map(course -> course + "\n").collect(Collectors.toSet()));
        System.out.println(courses.stream().sorted(courseWithMostStudentsIncreasingOrder).map(course->course+"\n").collect(Collectors.toList()));

        Comparator<Course> courseWithMostStudentsDecreasingOrder = Comparator.comparing(Course::getNoOfStudents).reversed();
        System.out.println(courses.stream().sorted(courseWithMostStudentsDecreasingOrder).map(course->course+"\n").collect(Collectors.toList()));

        Comparator<Course> courseWithMostStudentsAndReviews = Comparator
                .comparingInt(Course::getNoOfStudents)
                .thenComparingInt(Course::getReviewScore).reversed();

        System.out.println(courses
                .stream()
                .sorted(courseWithMostStudentsAndReviews)
                .map(course -> course+ "\n")
                .collect(Collectors.toList()));

        //get only top 5 score

        System.out.println(courses
                .stream()
                .sorted(courseWithMostStudentsAndReviews)
                .map(course -> course+ "\n")
                .limit(5)
                .collect(Collectors.toList()));

        Optional<Course> c = courses.stream().max(Comparator.comparing(Course::getNoOfStudents));
        System.out.println(c.get().getName());
        Map<String, Long> countGroups = courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()));
        System.out.println(countGroups);
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
    }

    private static List<Course> getCourseList() {
        return Arrays.asList(
                new Course("Spring", "Framework", 98, 10000),
                new Course("Spring", "Framework", 98, 10000),
                new Course("Microservices", "Distributed Computing", 99, 60000),
                new Course("AWS", "Cloud", 93, 25000),
                new Course("Java", "Language", 95, 54025),
                new Course("Node.js", "Language", 99, 54025),
                new Course("Docker", "Language", 92, 10000),
                new Course("Docker", "Language", 92, 10000)
        );
    }


}
