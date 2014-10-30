/**
 * key idea: dummy node, pre node indiactes the tail node that doesn't have 
 * duplicates
 * we look forward 2 nodes if there is duplicates we delete all duplicates
 * if note move tail node forward.
 * Time Complexity O(n)
 * Space Complexity O(1)
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        while (pre.next != null && pre.next.next != null) {
            if (pre.next.val == pre.next.next.val) {
                int temp = pre.next.val;
                while (pre.next!= null && pre.next.val == temp) {
                    pre.next = pre.next.next;
                }
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
