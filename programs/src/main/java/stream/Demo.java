package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("There");
        list.add("How");
        list.add("Is");
        list.add("It");
        list.add("Going");

        Stack<Character> stack = new Stack<>();
        stack.add('H');
        stack.add('e');
        stack.add('l');
        stack.add('l');
        stack.add('o');
        System.out.println(stack.toString());
        List<String> filterList = list.stream().filter(s->s.startsWith("I")).collect(Collectors.toList());
        System.out.println(filterList);
        List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);
        list.stream().forEach(System.out::println);
        System.out.println(list.stream().filter(s->s.startsWith("H")).count());
        //List<String> lengths = list.stream().map(String::length).collect(Collectors.toList())
    }
}
