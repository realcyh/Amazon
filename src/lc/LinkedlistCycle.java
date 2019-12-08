package lc;

import java.util.*;

public class LinkedlistCycle {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // hashset
//    public ListNode detectCycle(ListNode head) {
//        Set<ListNode> set = new HashSet<>();
//        int i = 0;
//        while (head != null) {
//            if (set.contains(head)) {
//                return head;
//            } else {
//                set.add(head);
//                head = head.next;
//            }
//        }
//        return null;
//    }

    // fast slow pointer

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode start = head;
        int cnt = -1;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {

                while (slow != start) {
                    slow = slow.next;
                    start = start.next;
                }
                // compute length
//                slow = slow.next;
//                cnt = 1;
//                while (start != slow) {
//                    cnt++;
//                    slow = slow.next;
//                }
//                System.out.println(cnt);
                return slow;
            }
        }
//        System.out.println(cnt);
        return null;
    }

}
