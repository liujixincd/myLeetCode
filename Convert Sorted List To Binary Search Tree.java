/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * Key Idea : recursion, dfs, if (len == 0) return null
 * use inorder traversal
 * time complexity O(n)
 */
public class Solution {
    ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int len = count(head);
        cur = head;
        return helper(head, len);
    }
    public TreeNode helper(ListNode head, int len) {
        if (len == 0) {
            return null;
        }
        TreeNode left = helper(head, len / 2);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = helper(cur, len - len / 2 - 1);
        root.left = left;
        root.right = right;
        return root;
    }
    public int count(ListNode head) {
        if (head == null) {
            return 0;
        }
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}