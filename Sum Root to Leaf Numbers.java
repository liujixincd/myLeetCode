/*
key idea : dfs, 3 situations: if the corrent root is a leaf
if not a leaf , return dfs on leftchild with sum * 10 + root.val and right with sum * 10 + right
 kinda like a preorder traversal: 
 time complexity: o(n)
 space comlexity o(logn)
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    public int helper(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }
        int left = root.left == null ? 0 : helper(root.left, sum * 10 + root.val);
        int right = root.right == null ? 0 : helper(root.right, sum * 10 + root.val);
        return left + right;
    }
}