/*
key idea: use a boolean array to record if this number has been added to the resutl set.
Time complexity()
Space complexity()
*/
public class Solution {
    public List<List<Integer>> permute(int[] num) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return res;
        }
        helper(res, new ArrayList<Integer>(), num, new boolean[num.length]);
        return res;
    }
    public void helper(ArrayList<List<Integer>> res, ArrayList<Integer> list, int[] num, boolean[] used) {
        if (list.size() == num.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!used[i]) {
                used[i] = true;
                list.add(num[i]);
                helper(res, list, num, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    } 
}