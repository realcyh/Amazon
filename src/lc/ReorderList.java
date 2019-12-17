package lc;

import java.util.*;

public class ReorderList {
    public class ListNode{
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        //0->1->2->3->4
        //0->4->1->3->2

        // find medium
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        // 0->1->2
        // 4->3
        ListNode prev = slow;
        ListNode curr = slow.next;
        prev.next = null;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        // merge two list
        ListNode p1 = head;
        ListNode p2 = prev;
        while (p1 != null) {
            ListNode tmp1 = p1.next;
            ListNode tmp2 = p2.next;
            p1.next = p2;
            p2.next = tmp1;
            p1 = tmp1;
            p2 = tmp2;
        }
    }
}
