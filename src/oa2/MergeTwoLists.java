package oa2;

public class MergeTwoLists {
    public static ListNode mergeTwo(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        else if (l2==null) return l1;

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }

    //recursive
    public static ListNode mergeTwoL(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoL(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoL(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(6); //6-9
        ListNode l2 = new ListNode(4); //4
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(4);
        l1.next = l3;
        l2.next = l4;
//        ListNode res = mergeTwo(l1, l2);
//        System.out.println(res.val);
//        System.out.println(res.next.val);
//        System.out.println(res.next.next.val);
//        System.out.println(res.next.next.next.val);

        ListNode res2 = mergeTwoL(l1, l2);
        System.out.println(res2.val);
        System.out.println(res2.next.val);
        System.out.println(res2.next.next.val);
        System.out.println(res2.next.next.next.val);
    }


}
