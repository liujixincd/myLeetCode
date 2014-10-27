/*
we find the pre node of Mth node and save the last node of the reversed node.
O(n)
O(1)
*/
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode last = pre.next;
        ListNode cur = pre.next;
        ListNode dummy2 = new ListNode(0);
        for (int j = 0; j < n - m + 1; j++) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = dummy2.next;
            dummy2.next = temp;
        }
        last.next = cur;
        pre.next = dummy2.next;
        return dummy.next;
    }
}
