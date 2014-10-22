/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//recursive
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(res, root);
        return res;
    }
    public void helper(ArrayList<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }
}
//iteration with stack
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeNode cur = root;
        TreeNode pre = root;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            TreeNode temp = s.peek().right;
            if (temp == null || temp == pre) {//when current stack top node doesn't have a right child or the right child has alreeady been visited 
                cur = s.pop();
                res.add(cur.val);//visit current node;
                pre = cur;
                cur = null;
            } else {
                cur = temp;
            }
        }
        return res;
    }
}
//iteration without stack
