/*
note: there is no duplicates in the tree.
key idea, recursion on the left and right of the current root in preorder
 */
public class Solution {
    int cur;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) {
             return null;
         }
         cur = 0;
         return helper(preorder, inorder, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int curPos = findPos(inorder, preorder[cur]);
        TreeNode root = new TreeNode(preorder[cur++]);
        root.left = helper(preorder, inorder, start, curPos - 1);
        root.right = helper(preorder, inorder, curPos + 1, end);
        return root;
    }
    public int findPos(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}