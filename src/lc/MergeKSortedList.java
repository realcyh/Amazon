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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(lists[0].val);
        ListNode start = res;

        for (int i=0; i<lists.length; i++) {
            while (lists[i].next != null) {
                if (res.val <= lists[i].val) {
                    res.next = lists[i];
                    res = res.next;
                    lists[i] = lists[i].next;
                } else {
                    ListNode temp = res;
                    res = lists[i];
                    res.next = res;
                    lists[i] = lists[i].next;
                    res = res.next;
                }
            }
        }
        return start;

    }
}
