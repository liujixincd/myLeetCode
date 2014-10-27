/*
key idea using an array with length of 32, count the 1 in each correspondent bit of every number
mod 3
build results.
O(n);
O(1);
*/
public class Solution {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int res = 0;
        int[] bits = new int[32];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < 32; j++) {
                bits[j] += (A[i] >> j) & 1;
            }
        }
        for (int i = 0; i < 32; i++) {
            bits[i] %= 3;
        }
        for (int i = 0; i < 32; i++) {
            res += bits[i] << i;
        }
        return res;
    }
}