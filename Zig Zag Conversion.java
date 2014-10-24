/*
step = 2 * (nRows - 1);
int the middle when out put j,
we need to output j + 2k, k the the remains rows number..
*/
public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows <= 1) {
            return s;
        }
        int step = 2 * (nRows - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < s.length(); j += step) {
                sb.append(s.charAt(j));
                if (i != 0 && i != nRows - 1 && j + 2 * (nRows - (i + 1)) < s.length()) {
                    sb.append(s.charAt(j + 2 * (nRows - (i + 1))));
                }
            }
        }
        return sb.toString();
    }
}