/**
 *Key Idea: dummy nodes, two pointer
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode pos1 = dummy;
        ListNode pos2 = dummy2;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            if (temp.val < x) {
                temp.next = pos1.next;
                pos1.next = temp;
                pos1 = pos1.next;
            } else {
                temp.next = pos2.next;
                pos2.next = temp;
                pos2 = pos2.next;
            }
        }
        pos1.next = dummy2.next;
        return dummy.next;
    }
}
