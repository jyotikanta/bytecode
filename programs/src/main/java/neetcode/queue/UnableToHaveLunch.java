package neetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Stack;

public class UnableToHaveLunch {
    public static void main(String[] args) {
        int[] students = new int[]{1,1,1,0,0,1};
        int[] sandwiches = new int[]{1,0,0,0,1,1};
        System.out.println(countStudents(students, sandwiches));
    }
    public static int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> studentsDeq = new ArrayDeque<>();
        Stack<Integer> sandwichStack = new Stack<>();
        for(int i=0;i<students.length;i++){
            studentsDeq.offerLast(students[i]);
            sandwichStack.add(sandwiches[students.length-i-1]);
        }

        int size = studentsDeq.size();
        while(!studentsDeq.isEmpty()){
            if(sandwichStack.isEmpty()){
                break;
            }
            if(Objects.equals(sandwichStack.peek(), studentsDeq.peek())){
                sandwichStack.pop();
                studentsDeq.poll();
                size = studentsDeq.size();
            }else{
                int tmp = studentsDeq.poll();
                studentsDeq.offerLast(tmp);

                //if continiously all the remaining students unable to eat lunch then break;
                size--;
                if(size==0){
                    break;
                }
            }
        }
        return studentsDeq.size();
    }

}
