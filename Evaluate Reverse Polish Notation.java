/*
 * key idea: using stack, then we started to pass the strign array
 * if we meet a number we parse it and put it in to the stack;
 * if we meet a operator we pop two numbers from the stack and calculate the 
 * results and push it to stack.
 * the last element in stack is the calculation results
 * Time Complexity o(n)
 * Space Complexity O(n)
 * */
public class Solution {
    public int evalRPN(String[] tokens) {
        int res = 0;
        if (tokens == null || tokens.length == 0) {
            return res;
        }
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            String cur = tokens[i];
            if ("+-*/".contains(cur)) {
                int b = s.pop();
                int a = s.pop();
                s.push(calculate(a, b, cur));
            } else {
                s.push(Integer.parseInt(cur));
            }
        }
        return s.pop();
    }
    public int calculate(int a, int b, String operator) {
        if (operator.equals("+")) {
            return a + b;
        } else if (operator.equals("-")) {
            return a - b;
        } else if (operator.equals("*")) {
             return a * b;
        } else {
            return a / b;
        }
    }
}
