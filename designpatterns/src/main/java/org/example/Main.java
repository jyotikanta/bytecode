package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String s = "Hello";
        System.out.println(s.hashCode());
        String p = "Hello";
        System.out.println(p.hashCode());
        System.out.println("A".hashCode());
        System.out.println("a".hashCode());
        System.out.println("AB".hashCode());
    }
}