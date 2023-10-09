package neetcode.stack;

import java.util.Stack;

public class RPN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> operandStack = new Stack<>();
        int operand1,operand2;
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    operand1 = operandStack.pop();
                    operand2 = operandStack.pop();
                    operandStack.push(operand2 + operand1);
                    break;
                case "-":
                    operand1 = operandStack.pop();
                    operand2 = operandStack.pop();
                    operandStack.push(operand2 - operand1);
                    break;
                case "*":
                    operand1 = operandStack.pop();
                    operand2 = operandStack.pop();
                    operandStack.push(operand2 * operand1);
                    break;
                case "/":
                    operand1 = operandStack.pop();
                    operand2 = operandStack.pop();
                    operandStack.push(operand2 / operand1);
                    break;
                default:
                    operandStack.push(Integer.parseInt(tokens[i]));
                }
            }
        return operandStack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
    }
}
