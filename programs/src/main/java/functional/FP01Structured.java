package functional;

import java.util.Arrays;
import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
        System.out.println("=======================EVEN======================");
        printAllEvenNumbersFromTheList(Arrays.asList(23,12,5,8,1,9,7,12,64,99));
        System.out.println("=======================ODD=======================");
        printAllOddNumbersFromTheList(Arrays.asList(23,12,5,8,1,9,7,12,64,99));
        System.out.println("=======================CUBE======================");
        printCubeOfAllEvenNumbersFromTheList(Arrays.asList(23,12,5,8,1,9,7,12,64,99));
        System.out.println("=======================SUM======================");
        printSumOFAllNumbersInTheList(Arrays.asList(23,1,1,23,12,5,8,1,9,7,12,64,99));


    }

    private static void printSumOFAllNumbersInTheList(List<Integer> list) {
        System.out.println(list.stream()
                .reduce(FP01Structured::sum));
    }

    private static void printCubeOfAllEvenNumbersFromTheList(List<Integer> list) {
        list.stream()
                .filter(FP01Structured::isOdd)
                .map(n->n*n*n + " ")
                .forEach(System.out::print);
        System.out.println();
    }

    private static void printAllOddNumbersFromTheList(List<Integer> list) {
        list.stream()
                .filter(FP01Structured::isOdd)
                .map(n-> n +" ")
                .forEach(System.out::print);
        System.out.println();
    }

    private static void printAllEvenNumbersFromTheList(List<Integer> list) {
        list.stream()
                .filter(FP01Structured::isEven)
                .map(n-> n+" ")
                .forEach(System.out::print);
        System.out.println();
    }

    private static boolean isOdd(int n){
        return n%2!=0;
    }

    private static boolean isEven(int n){
        return n%2==0;
    }

    private static int sum(int a, int b){
        System.out.println(a + " " + b);
        return a+b;
    }

}
