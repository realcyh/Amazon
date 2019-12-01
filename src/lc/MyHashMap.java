package lc;

public class MyHashMap {
    // unfinished
    final ListNode[] nodes = new ListNode[10000];

    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = index(key);
        ListNode tmp = new ListNode(key, value);
        if (nodes[idx] == null) {
            nodes[idx] = tmp;
            tmp.next = null;
        } else {

        }
        nodes[idx] = tmp;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = index(key);
        if (nodes[idx] == null) return -1;
        return nodes[idx].val;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = index(key);
        nodes[idx] = null;
    }

    public int index(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    class ListNode {
        int key, val;
        ListNode next;
        ListNode (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyHashMap m = new MyHashMap();

        System.out.println(Integer.hashCode(21690));

    }
}
