/*
global variable, recursion divide and conqur
Time Complexity O(n +) Space Complexity O(1) 
 */
public class Solution {
    int cur;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        cur = postorder.length - 1;
        return helper(postorder, inorder, 0, postorder.length - 1);
    }
    public TreeNode helper(int[] postorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[cur]);
        int pos = find(inorder, postorder[cur]);
        cur--;
        root.right = helper(postorder, inorder, pos + 1, end);
        root.left = helper(postorder, inorder, start, pos - 1);
        return root;
    }
    public int find(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}