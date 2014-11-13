/**
 * key idea two pointers
 * Time Complexity O(n)
 * Time Complexity O(1)
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
