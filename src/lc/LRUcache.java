package lc;

import java.util.HashMap;

class LRUcache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode ret = tail.pre;
        this.removeNode(ret);
        return ret;
    }

    private HashMap<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    int capacity;
    int count;
    private DLinkedNode head, tail;


//    public LRUCache(int capacity) {
//        this.count = 0;
//        this.capacity = capacity;
//
//        head = new DLinkedNode();
//        head.pre = null;
//
//        tail = new DLinkedNode();
//        tail.post = null;
//
//        head.post = tail;
//        tail.pre = head;
//    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);

        if (node == null) return -1;

        this.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);
            count++;

            if (count > capacity) {
                DLinkedNode tail = popTail();
                this.cache.remove(tail.key);
                count--;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }

    }


}



