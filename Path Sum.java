// use recursion.
// when current node is a leaf node and current node's value is sum. return true
// else do recursion on left and right child of current node with sum - current node's 
// value to see if there is a possible answer
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}