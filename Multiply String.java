public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int temp =(int)(num2.charAt(j) - '0') * (int)(num1.charAt(i) - '0') + carry + res[i + j + 1];
                res[i + j + 1] = temp  % 10;
                carry = temp / 10;
            }
            res[i] = carry;
        }
        int pos = 0;
        while (pos < res.length - 1 && res[pos] == 0) {
            pos++;
        }
        StringBuilder sb = new StringBuilder();
        while (pos < res.length) {
            sb.append(res[pos++]);
        }
        return sb.toString();
    }
}