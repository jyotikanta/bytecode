package neetcode.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/valid-anagram
public class Anagram {
    public static void main(String[] args) {
        String a = "eat";
        String b = "teaa";
        System.out.println("Is " + a + " and " + b + " Valid Anagram : " + isAnagram(a, b));
    }

    private static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        {
            return false;
        }
        char arrA[] = s.toCharArray();
        Arrays.sort(arrA);
        char arrB[] = t.toCharArray();
        Arrays.sort(arrB);

        return arrA.equals(arrB);
    }
}