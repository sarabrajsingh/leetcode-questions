import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String[] tokens = { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                // imagine we read 2, 1 and we want to do 2-1
                int op2 = stack.pop(); // 1
                int op1 = stack.pop(); // 2
                stack.push(op1 - op2);
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                // same thing with divisions is that we need to take care of the ordering
                // of the operations
                int denominator = stack.pop();
                int numerator = stack.pop();
                stack.push(numerator / denominator);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}
