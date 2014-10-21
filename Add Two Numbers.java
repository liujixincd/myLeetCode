/*
Idea, add the current L1 and L2 node and maintain the carry.
if at last carry is no zero,
we need to add a new node for carry.
time complexity O(m + n)
*/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + carry;
            ListNode newNode = new ListNode(temp % 10);
            carry = temp / 10;
            cur.next = newNode;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int temp = l1.val + carry;
            ListNode newNode = new ListNode(temp % 10);
            carry = temp / 10;
            cur.next = newNode;
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int temp = l2.val + carry;
            ListNode newNode = new ListNode(temp % 10);
            carry = temp / 10;
            cur.next = newNode;
            cur = cur.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            cur.next = newNode;
        }
        return dummy.next;
    }
}