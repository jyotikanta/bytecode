package functional;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class BehaviourParameterization {
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
                return num * num;
            }
        };

        //Consumer<Integer> println = System.out::println;
        Consumer<Integer> println = new Consumer<Integer>() {
            @Override
            public void accept(Integer num) {
                System.out.println(num);
            }
        };
        BinaryOperator<Integer> integerBinaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer num1, Integer num2) {
                return num1+num2;
            }
        };

        sumDoubleTheEvenNumbers(list, evenPredicate,doubleFunction, integerBinaryOperator);


        Supplier<Integer> supplier = ()->new Random().nextInt(1000);
        System.out.println(supplier.get());
        UnaryOperator<Integer> unaryOperator = (x)->x*2;
        System.out.println(unaryOperator.apply(23));

        BiPredicate<Object,Class<?>> biPredicate = (a, b) -> b.isInstance(a);
        System.out.println(biPredicate.test(new Integer(12),Integer.class));

        BiFunction<Integer, String, String> biFunction = (i,s)->i+s;
        System.out.println(biFunction.apply(1, " one"));
        Map<Integer,Integer> map =  list.stream().sorted().distinct().collect(Collectors.toMap(doubleFunction,doubleFunction));
        map.keySet().stream().sorted().forEach(System.out::println);



    }

    private static void sumDoubleTheEvenNumbers(List<Integer> list, Predicate<Integer> evenPredicate, Function<Integer, Integer> doubleFunction, BinaryOperator<Integer> integerBinaryOperator) {

        Integer res = list.stream()
                .filter(evenPredicate)
                .map(doubleFunction)
                .reduce(0, integerBinaryOperator);
                //.forEach(println);
        System.out.println(res);
    }
}
