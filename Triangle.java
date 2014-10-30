/*
 * key idea dp, from bottom to top
 * state transformation function is res[i][j] = Math.min(res[i + 1][j], res[i +
 * 1][j + 1] + t.get(i).get(j)
 * Also, we can reduce the memory use to O(n)
 * because each row in dp only used the previous row,
 * Time Complexity O(n ^ 2)
 * Space Comlexity O(n)
 *
 * */
public class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        if (t == null || t.size() == 0 || t.get(0).size() == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int[] res = new int[t.size()];
        for (int i = 0; i < t.get(t.size() - 1).size(); i++) {
            res[i] = t.get(t.size() - 1).get(i);
        }
        for (int i = t.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                res[j] = Math.min(res[j], res[j + 1]) + t.get(i).get(j);
            }
        }
        return res[0];
    }
}
