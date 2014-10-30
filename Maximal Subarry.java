/*
 * key idea: global is maximal local value, local value is considering adding
 * A[i] or not.
 * Time Complexity O(n)
 * Space Complexity O(1);
 *
 * */
public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int global = A[0];
        int local = A[0];
        for (int i = 1; i < A.length; i++) {
            local = Math.max(local+ A[i], A[i]);
            global = Math.max(global, local);
        }
        return global;
    }
}
