package neetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BackSpaceCompare {
    public static void main(String[] args) {
        System.out.println(backSpaceCompare("xywrrmp", "xywrrm#p"));
    }
    public static boolean backSpaceCompare(String s, String t) {
        Deque<Character> stackS = new ArrayDeque<>();
        Deque<Character> stackT = new ArrayDeque<>();
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
