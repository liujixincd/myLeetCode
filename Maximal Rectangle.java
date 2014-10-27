/*
for each row, do a larget rectangle in histrogram update the max area if we found a larger one
time complexity O(n ^ 2);
space complexity O(n)
*/
public class Solution {
    public int maximalRectangle(char[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[] h = new int[m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == '1') {
                    h[j] = h[j] + 1;
                } else {
                    h[j] = 0;
                }
            }
            max = Math.max(max, calculateArea(h));
        }
        return max;
    }
    public int calculateArea(int[] h) {
        if (h == null || h.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < h.length; i++) {
            if (!s.isEmpty()) {
                while (!s.isEmpty() && h[s.peek()] >= h[i]) {
                    int cur = s.pop();
                    if (s.isEmpty()) {
                        max = Math.max(max, h[cur] * i);
                    } else {
                        max = Math.max(max, h[cur] * (i - 1 - s.peek()));
                    }
                }
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            int cur = s.pop();
            if (s.isEmpty()) {
                max = Math.max(max, h[cur] * h.length);
            } else {
                max = Math.max(max, h[cur] * (h.length - s.peek() - 1));
            }
        }
        return max;
    }
}