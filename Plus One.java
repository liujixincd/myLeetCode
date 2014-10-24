/*
key idea : maintain a carry, if carry is 0 return the original string
if carry is not zero when we finish the loop,
return a new array with length of the orginal array plus one and the first number(most significant number is 1)
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length ==0) {
            return null;
        }
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + carry;
            digits[i] = temp % 10;
            carry = temp / 10;
            if (carry == 0) {
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        if (carry == 1) {
            res[0] = 1;
        }
        return res;
    }
}