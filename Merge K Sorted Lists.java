/*
 * key idea: using heap(priority queue)
 * time complexity O(n);
 * space complexity O(k);
 */
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        Comparator<ListNode> cmp = new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        };
        Queue<ListNode> q = new PriorityQueue<ListNode>(lists.size(), cmp);
        for (ListNode head : lists) {
            if (head != null) {
                q.offer(head);
            }
        }
        while (!q.isEmpty()) {
            ListNode temp = q.poll();
            if (temp.next != null) {
                q.offer(temp.next);
            }
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next;
        }
        return dummy.next;
    }
}
