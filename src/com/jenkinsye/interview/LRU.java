package com.jenkinsye.interview;

import java.util.HashMap;

public class LRU {
    private HashMap<String, DLinkedNode> dict;
    private int capacity;
    private int count;
    private DLinkedNode head, tail;

    public LRU(int capacity) {
        dict = new HashMap<>();
        this.capacity = capacity;
        count = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(String key) {
        DLinkedNode node = dict.get(key);
        if (node == null)
            return -1;
        moveToHead(node);
        return node.value;
    }

    public void set(String key, int value) {
        DLinkedNode node = dict.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            node = new DLinkedNode();
            node.key = key;
            node.value = value;
            dict.put(key, node);
            count++;
            if (count > capacity) {
                DLinkedNode out = removeTail();
                dict.remove(out.key);
                count--;
            } else {
                moveToHead(node);
            }
        }
    }

    public DLinkedNode removeTail() {
        DLinkedNode temp = tail.pre;
        removeNode(temp);
        return temp;
    }

    public void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = node.next = null;
    }

    public void addNode(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }
}

class DLinkedNode {
    String key;
    int value;
    DLinkedNode next;
    DLinkedNode pre;
}
