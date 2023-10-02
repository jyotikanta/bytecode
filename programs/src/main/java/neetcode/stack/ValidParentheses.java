package neetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Map<Character,Character> paraMap = new HashMap<>();
        paraMap.put(')','(');
        paraMap.put('}','{');
        paraMap.put(']','[');
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length();i++)
        {
            if(stack.isEmpty())
            {
                stack.push(s.charAt(i));
                continue;
            }
            Character toBeInserted = paraMap.get(s.charAt(i));
            if(toBeInserted != null)
            {
                if(toBeInserted==stack.peek())
                {
                    stack.pop();
                }
                else
                {
                    return false;
                }
            }
            else
            {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
}
