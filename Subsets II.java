/*
Idea: use DFS to search for all possilbe subsets, becareful to skip the duplicates and sorted the array first.
Time Complexity O(2^n) Space complexity(O(n)) result sets n * 2 ^ n
*/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        helper(res, num, new ArrayList<Integer>(), 0);
        return res;
    }
    public void helper(ArrayList<List<Integer>> res, int[] num, ArrayList<Integer> list, int pos) {
        res.add(new ArrayList<Integer>(list));
        for (int i = pos; i < num.length; i++) {
            if (i > pos && num[i] == num[i - 1]) {
                continue;
            }
            list.add(num[i]);
            helper(res, num, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}