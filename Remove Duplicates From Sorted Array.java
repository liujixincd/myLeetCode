/*
two pointers, time complexity o(n), space complexity O(1)
*/
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int pos = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > 0 && A[i] == A[i - 1]) {
                continue;
            }
            A[pos++] = A[i];
        }
        return pos;
    }
}