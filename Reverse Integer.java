/*
res and temp should be long and take consideration of negative input.
*/

public class Solution {
    public int reverse(int x) {
        boolean isNeg = x > 0 ? false : true;
        long res = 0;
        long temp = Math.abs((long)x);
        while (temp > 0) {
            res = res * 10 + temp % 10;
            temp /= 10;
        }
        return isNeg ? - (int) res : (int)res;
    }
}