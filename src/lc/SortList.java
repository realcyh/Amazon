package lc;

import java.util.PriorityQueue;

public class SortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        while (head != null) {
            heap.add(head.val);
            head = head.next;
        }
        ListNode curr = new ListNode(heap.poll());
        ListNode res = curr;
        while (!heap.isEmpty()) {
            curr.next = new ListNode(heap.poll());
            curr = curr.next;
        }
        return res;

    }
}
