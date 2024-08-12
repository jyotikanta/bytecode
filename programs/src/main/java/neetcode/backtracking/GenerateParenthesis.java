package neetcode.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        System.out.println(gp.generateParanthesis(3));
    }

    List<Character> list = new ArrayList<>();
    List<String> res = new ArrayList<>();
    private List<String> generateParanthesis(int n) {
        backtrack(0,0,n);
        return res;

    }

    private void backtrack(int openN, int closedN, int n) {
        if(list.size()==n*2) {
            Iterator<Character> value = list.iterator();
            StringBuilder temp = new StringBuilder();
            while(value.hasNext()){
                temp.append(value.next());
            }
            res.add(temp.toString());
        }

        if(openN < n){
            list.add('(');
            backtrack(openN + 1, closedN , n);
            list.remove(list.size()-1);
        }
        if(closedN < openN){
            list.add(')');
            backtrack(openN, closedN + 1, n);
            list.remove(list.size()-1);
        }
    }

}
