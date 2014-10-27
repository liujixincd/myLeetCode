/*
key idea: after sort the inital array,
 if num[i] == num[i - 1] and we didn't use the num[i - 1] the we should skip doing dfs on num[i]
*/
public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        helper(res, new ArrayList<Integer>(), num, new boolean[num.length]);
     return res;
    }
    public void helper(ArrayList<List<Integer>> res, ArrayList<Integer> list, int[] num, boolean[] used) {
        if (list.size() == num.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1] && used[i - 1] == false) {
                continue;
            } else {
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
}
