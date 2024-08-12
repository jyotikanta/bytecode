package neetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class UnableToHaveLunch {
    public static void main(String[] args) {
        int[] students = new int[]{1,1,0,0};
        Deque<Integer> studentsDeq = new ArrayDeque<>();
        for(int student:students){
            studentsDeq.offerLast(student);
        }
        System.out.println(studentsDeq);
    }

}
