/*
Stack, 
put left parentheses into stack
if current char is right parentheses
check if it can match the top of the stack()
Time Complexity O(n)
Space Complexity O(n)
*/
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if ("({[".contains(String.valueOf(s.charAt(i)))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (!isValid(stack.peek(), s.charAt(i))) {
                        return false;
                    }
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
    public boolean isValid(char a, char b) {
        if (a == '(' && b == ')' || a == '[' && b == ']' || a == '{' && b == '}') {
            return true;
        }
        return false;
    }
}