/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if (n <= 0) {
            res.add(null);
            return res;
        }
        res = helper(1, n);
        return res;
    }
    public ArrayList<TreeNode> helper(int start, int end) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> leftList = helper(start, i - 1);
            ArrayList<TreeNode> rightList = helper(i + 1, end);
            for (int j = 0; j < leftList.size(); j++) {
                for (int k = 0; k < rightList.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftList.get(j);
                    root.right = rightList.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
