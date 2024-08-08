package functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03Structured {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 21,40, 1, 9, 100, 12, 64, 99);

        //Predicate<Integer> evenPredicate = num->num%2==0;
        Predicate<Integer> evenPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer num) {
                return num%2==0;
            }
        };

        //Function<Integer, Integer> doubleFunction = num->num*num;
        Function<Integer, Integer> doubleFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer num) {
                return num*num;
            }
        };

        //Consumer<Integer> println = System.out::println;
        Consumer<Integer> println = new Consumer<Integer>() {
            @Override
            public void accept(Integer num) {
                System.out.println(num);
            }
        };
        list.stream()
                .filter(evenPredicate)
                .map(doubleFunction)
                .forEach(println);
    }
}
