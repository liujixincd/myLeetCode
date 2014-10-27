/*
key idea: for each string starting from index 1 we compare the commomPrefix, maintain the length of
common prefix
O(n * m) m is the  maximum length of string in the array.
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < res.length() && j < strs[i].length() && res.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            if (j == 0) {
                return "";
            }
            res = res.substring(0, j);
        }
        return res;
    }
}