/*
idea from front to end
calculate different situations
*/
public class Solution {
    public String intToRoman(int num) {
        if (num > 3999 || num <= 0) {
            return "";
        }
        int[] number = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int pos = 0;
        String res = "";
        while (num > 0) {
            int count = num / number[pos];
            for (int i = 0; i < count; i++) {
                res += strs[pos];
            }
            num -= number[pos] * count;
            pos++;
        }
        return res;
    }
}