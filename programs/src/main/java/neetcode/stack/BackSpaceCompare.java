package neetcode.stack;

import java.util.Stack;

public class BackSpaceCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("xywrrmp", "xywrrm#p"));
    }
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for(char c:s.toCharArray())
        {
            if(c!='#')
            {
                stackS.push(c);
            }
            else
            {
                if(!stackS.isEmpty())
                    stackS.pop();
            }
        }
        for(char c:t.toCharArray())
        {
            if(c!='#')
            {
                stackT.push(c);
            }
            else
            {
                if(!stackT.isEmpty())
                    stackT.pop();
            }
        }
        if(stackS.size()==stackT.size())
        {
            while(!stackS.isEmpty())
            {
                if(stackS.pop()!=stackT.pop())
                {
                    return false;
                }
            }
            return true;
        }
        else
        {
            return false;
        }

    }
}
