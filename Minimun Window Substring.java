//use window method
//maintain an indicator to the start of a candidate string that satisfy the requirement
//HashMap
//time complexity O(n), space(O(n))
public class Solution {
    public String minWindow(String S, String T) {
        String res = "";
        int minLen = S.length() + 1;
        int count = 0;
        int start = 0;
        if (S == null || T == null || S.length() < T.length()) {
            return res;
        }
        HashMap<Character, Integer> toFind = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (toFind.containsKey(c)) {
                toFind.put(c, toFind.get(c) + 1);
            } else {
                toFind.put(c, 1);
            }
        }
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (toFind.containsKey(c)) {
                toFind.put(c, toFind.get(c) - 1);
                if (toFind.get(c) >= 0) {
                    count++;
                }
                if (count == T.length()) {
                    while (count == T.length()) {
                        if (toFind.containsKey(S.charAt(start))) {
                            toFind.put(S.charAt(start), toFind.get(S.charAt(start)) + 1);
                            if (toFind.get(S.charAt(start)) > 0) {
                                count--;
                                if (i - start + 1 < minLen) {//find a shorter subtring
                                    minLen = i - start + 1;
                                    res = S.substring(start, i + 1);
                                }
                            }
                        }
                        start++;//new start = the index that after deletion of this character substring no longer satisfy the requirements + 1
                    }
                }
            }
        }
        return res;
    }
}