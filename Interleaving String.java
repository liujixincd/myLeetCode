/*
 * key idea: dynamic programming 
 * O(n^2)
 * O(n^2)
 * */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] res = new boolean[s1.length() + 1][s2.length() + 1];
        res[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            res[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1);
            if (res[i][0] == false) {
                break;
            }
        }
        for (int j = 1; j <= s2.length(); j++) {
            res[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1);
            if (res[0][j] == false) {
                break;
            }
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                res[i][j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) && res[i - 1][j] || s2.charAt(j - 1) == s3.charAt(i + j - 1) && res[i][j - 1];
            }
        }
        return res[s1.length()][s2.length()];
    }
}
