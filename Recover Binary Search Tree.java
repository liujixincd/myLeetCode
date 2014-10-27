/*
 * key idea: for a bst if we use a pre-order traversal, the results should be a sorted array.
 * Time Complexity O(n);
 * Space Complexity O(logn) 
 * */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                }
                if (pre.right == cur) {
                    res.add(cur.val);
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
