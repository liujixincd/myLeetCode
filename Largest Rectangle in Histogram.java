/*
key idea: we maintain an undescending stack
the element stack is the index of a single rectanle.
if current rectangle is grater than the stack top rectangle
we push the current rectangle index into the stack
else 
we pop the stack, the largest rectangle that tha poped rectangle can formed is starting from 
cur index - 1 to s.peek() + 1
when we finished adding all single rectangles' index to the stack
we used a loop to pop all index in the stack
for each poped index
we calculate the maximal rectangle it can form and update maxarea if we can find a bigger one.

Time Complexity O(n)
Space Complexity O(n)

*/
public class Solution {
    public int largestRectangleArea(int[] h) {
        if (h == null || h.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < h.length; i++) {
            if (!s.isEmpty()) {
                if (h[i] < h[s.peek()]) {
                    while (!s.isEmpty() && h[s.peek()] >= h[i]) {
                        int cur = s.pop();
                        if (s.isEmpty()) {
                            max = Math.max(max, h[cur] * i);
                        } else {
                            max = Math.max(max, h[cur] * (i - s.peek() - 1));
                        }
                    }
                }
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            int cur = s.pop();
            if (s.isEmpty()) {
                max = Math.max(max, h.length * h[cur]);
            } else {
                max = Math.max(max, (h.length - s.peek() - 1) * h[cur]);
            }
        }
        return max;
    }
}