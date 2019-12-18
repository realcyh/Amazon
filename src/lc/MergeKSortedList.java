package lc;

import java.util.*;

public class MergeKSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    // priority queue
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for (int i=0; i<lists.length; i++) {
            if (lists[i] != null) pq.add(lists[i]);
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }

        return dummy.next;
    }

    // recursive merge sort
    public ListNode mergeKLists2(ListNode[] lists) {
        return partition(lists, 0, lists.length-1);
    }

    public ListNode partition (ListNode[] lists, int l, int h) {
        if (l == h) return lists[l];
        if (l < h) {
            int m = (l+h)/2;
            ListNode l1 = partition(lists, l, m);
            ListNode l2 = partition(lists, m+1, h);
            return merge(l1, l2);
        } else return null;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        MergeKSortedList m = new MergeKSortedList();
        ListNode a = m.new ListNode(1);
        a.next = m.new ListNode(4);
        a.next.next = m.new ListNode(5);
        ListNode b = m.new ListNode(1);
        b.next = m.new ListNode(3);
        b.next.next = m.new ListNode(4);
        ListNode c = m.new ListNode(0);
        c.next = m.new ListNode(2);
        c.next.next = m.new ListNode(6);
        ListNode[] lists = {a, b, c};
        ListNode res = m.mergeKLists(lists);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }


        String s = "asdf";
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        System.out.println(sb);

    }
}
