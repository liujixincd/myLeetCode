/*
key idea HashMap to record how many characters still need to find for characters in String T 
left bound
Time Complexity O(n): 2 passes
Space Complexity O(n) 

*/
public class Solution {
    public String minWindow(String S, String T) {
        if (S == null || T == null || S.length() < T.length()) {
            return "";
        }
        HashMap<Character, Integer> toFind = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
            if (toFind.containsKey(T.charAt(i))) {
                toFind.put(T.charAt(i), toFind.get(T.charAt(i)) + 1);
            } else {
                toFind.put(T.charAt(i), 1);
            }
        }
        String res = "";
        int matched = 0;
        int start = 0;
        int maxLen = S.length() + 1;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (toFind.containsKey(c)) {
                toFind.put(c, toFind.get(c) - 1);
                if (toFind.get(c) >= 0) {
                    matched++;
                }
                while (matched == T.length()) {
                    if (toFind.containsKey(S.charAt(start))) {
                        toFind.put(S.charAt(start), toFind.get(S.charAt(start)) + 1);
                        if (toFind.get(S.charAt(start)) > 0) {
                            matched--;
                            if (i - start + 1 < maxLen) {
                                maxLen = i - start + 1;
                                res = S.substring(start, i + 1);
                            }
                        }
                    }
                    start++;
                }
            }
        }
        return res;
    }
}