/**
 * key Idea:recursion find the mid element as root, build left child on start,
 * mid - 1, build right child on mid + 1, end
 *
 * Time complexity O(n)
 * Space Complexity O(n);
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        return helper (num, 0, num.length - 1);
    }
    public TreeNode helper (int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = helper(num, start, mid - 1);
        root.right = helper (num, mid + 1, end);
        return root;
    }
}
