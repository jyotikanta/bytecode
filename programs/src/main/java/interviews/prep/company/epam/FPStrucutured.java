package interviews.prep.company.epam;

import java.util.Arrays;
import java.util.List;

public class FPStrucutured {
    public static void main(String[] args) {
        //printAllNumbersInListStructured(Arrays.asList(12,9,3,4,2,1,65,1));
        printEvenNumbersInListStructured(Arrays.asList(12,9,3,4,2,1,65,1));

        printCoursesInListStructured(Arrays.asList("Spring","Spring Boot","Java", "Kubernetes", "Kafka"));
        printCoursesContaining(Arrays.asList("Spring","Spring Boot","Java", "Kubernetes", "Kafka","AWS"), "Spri");

        System.out.println(sumAlltheNumberInTheList(Arrays.asList(12,9,3,4,2,1,65,1)));
    }

    private static int sumAlltheNumberInTheList(List<Integer> list) {
        return list.stream().reduce(0,Integer::sum);
    }

    private static void printCoursesInListStructured(List<String> list) {
        list.stream().forEach(System.out::println);
    }

    private static void printCoursesContaining(List<String> list, String str) {
        list.stream().filter(s->s.contains(str)).forEach(System.out::println);
        list.stream().filter(s->s.length()>=4).forEach(System.out::println);

    }

    public void print(Integer i){
        System.out.print(i+ " ");
    }

    public static boolean isEven(int i){
        return i%2==0;
    }
    public static void printAllNumbersInListStructured(List<Integer> numbers){
        numbers.stream().forEach(new FPStrucutured()::print);
        System.out.println();
        numbers.stream().forEach(System.out::println);
    }

    public static void printEvenNumbersInListStructured(List<Integer> numbers){
        numbers.stream().filter(num->num%2==0).forEach(new FPStrucutured()::print);
        System.out.println();
        numbers.stream().forEach(System.out::println);
    }
}
