//trim
//decide it is positive or negative
//decide if it is overflow
//return res;
//time complexity O(n)
public class Solution {
    public int atoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        //trim space
        boolean isNeg = false;
        int pos = 0;
        while (pos < str.length() && str.charAt(pos) == ' ') {
            pos++;
        }
        if (str.charAt(pos) == '+' || str.charAt(pos) == '-') {
            if (str.charAt(pos) == '-') {
                isNeg = true;
            }
            pos++;
        }
        int res = 0;
        while (pos < str.length()) {
            if (Character.isDigit(str.charAt(pos))) {
                int digit =(int)(str.charAt(pos) - '0');
                if (!isNeg && res > (Integer.MAX_VALUE - digit) / 10) {
                    return Integer.MAX_VALUE;
                } else if (isNeg && res > -((Integer.MIN_VALUE + digit) / 10)) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + digit;
                pos++;
            } else {
                break;
            }
        }
        return isNeg ? -res : res;
    }
}