/*
 *key idea: using hashSet
Time Complexity O(n);
Space Complexity O(n);
 *
 * */
public class Solution {
     public int longestConsecutive(int[] num) {
        int res = 0;
        if (num == null || num.length == 0) {
            return res;
        }
        HashSet<Integer> s = new HashSet<Integer>();
        for (int i : num) {
            s.add(i);
        }
        while(!s.isEmpty()) {
            int temp = 1;
            Iterator itr = s.iterator();
            int cur = (int)itr.next();
            s.remove(cur);
            int left = cur - 1;
            int right = cur + 1;
            while (s.contains(left)) {
                temp++;
                s.remove(left);
                left--;
            }
            while (s.contains(right)) {
                temp++;
                s.remove(right);
                right++;
            }
            res = Math.max(res, temp);
        }
        return res;
    }
}
