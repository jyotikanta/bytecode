package neetcode.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        System.out.println(gp.generateParanthesis(3));
    }

    Stack<Character> stack = new Stack<>();
    List<String> res = new ArrayList<>();
    private List<String> generateParanthesis(int n) {
        backtrack(0,0,n);
        return res;

    }

    private void backtrack(int openN, int closedN, int n) {
        if(openN == closedN && closedN == n) {
            Iterator value = stack.iterator();
            String temp = "";
            while(value.hasNext()){
                temp = temp +value.next();
            }
            res.add(temp);
        }

        if(openN < n){
            stack.push('(');
            backtrack(openN + 1, closedN , n);
            stack.pop();
        }
        if(closedN < openN){
            stack.push(')');
            backtrack(openN, closedN + 1, n);
            stack.pop();
        }
    }

}
