public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }
        int i = 0;
        int j = 0;
        int mark = -1;
        int posStar = -1;
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                mark = i;
                posStar = j;
                j = j + 1;
            } else {
                if (posStar != -1) {
                    i = ++mark;
                    j = posStar + 1;
                } else {
                    return false;
                }
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }
}