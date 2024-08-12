package functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Structured {
    public static void main(String[] args) {
        System.out.println("=======================Sum======================");
        List<Integer> list = Arrays.asList(23, 12, 5, 8, 1, 9, 7, 12, 64, 99);
        addAllNumbers(list);

        System.out.println("===================Doubled List==================");
        List<Integer> doubledList = list.stream().map(n->n*n).collect(Collectors.toList());
        doubledList.stream().map(n->n+" ").forEach(System.out::print);
        System.out.println();

        System.out.println("=======================Distinct==================");
        list.stream().distinct().sorted().map(n->n+" ").forEach(System.out::print);
        System.out.println();

        List<String> courses = Arrays.asList("GCP","AWS","DS","OS","Networking","Docker","K8","Microservices","Distributed Computing");
        System.out.println("=======================Courses===================");
        courses.stream().sorted().map(c->c+"->"+c.length()+" ").forEach(System.out::print);
        System.out.println();
        courses.stream().sorted(Comparator.comparing(str->str.length())).map(c->c+" ").forEach(System.out::print);
        //or
        System.out.println();
        courses.stream().sorted(Comparator.comparing(String::length)).map(c->c+" ").forEach(System.out::print);
        System.out.println();
        courses.stream().sorted(Comparator.reverseOrder()).map(c->c+" ").forEach(System.out::print);




    }

    private static void addAllNumbers(List<Integer> list) {
        int res = list.stream().reduce(0, (a,b)->a+b);
        System.out.println(res);
        //or use method reference
        res = list.stream().reduce(0,Integer::sum);
        System.out.println(res);
    }


}
