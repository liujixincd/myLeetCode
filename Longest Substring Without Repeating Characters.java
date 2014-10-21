// time complexity O(N) extra space O(n) every character in string will be accessed at most twice.
//key idea, maintain a window of unrepeated substring. we meet a repeated character, move new left bound to the index that that the chracter appeared for the fisrt time + 1
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<Character>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                max = Math.max(max, i - start + 1);
            } else {
                while (s.charAt(start) != s.charAt(i)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
        }
        return max;
    }
}