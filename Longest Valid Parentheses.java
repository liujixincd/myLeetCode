/*
key idea: use the stack, and maintain a start index which means the start of a valid parentheses
when we meet a left ( we just pust its index in to the stack,
when we meet a right ) we just pop() from stack
when we do the pop() operation
there are two possiblilities
first:
the stack is empty, means no valid parenthese before i
new start would be i + 1;
if after pop() the stack is not empty()
means that valid parentheses is starting from  s.peek() +  1 to i;
if after pop() the stack is empty,
means that valid parentheses is starting from start to i;

*/
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        int start = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }  else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i - start + 1);
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }
        }
        return maxLen;
    }
}