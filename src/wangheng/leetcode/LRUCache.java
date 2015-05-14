package wangheng.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node headDummy;
    Node tailDummy;
    
    public LRUCache(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity need to be positive.");
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        headDummy = new Node(0, 0);
        tailDummy = new Node(0, 0);
        headDummy.next = tailDummy;
        tailDummy.pre = headDummy;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            refresh(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            refresh(node);
            node.val = value;
        } else {
            if (map.size() == capacity) {
                remove(headDummy.next);
            }
            
            node = new Node(key, value);
            add(node);
        }
    }
    
    private void refresh(Node node) {
        if (node == tailDummy.pre) return;
        
        remove(node);
        add(node);
    }
    
    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        map.remove(node.key);
    }
    
    private void add(Node node) {
        node.pre = tailDummy.pre;
        node.next = tailDummy;
        node.pre.next = node;
        tailDummy.pre = node;

        map.put(node.key, node);
    }
    
    private class Node {
        int key;
        int val;
        Node pre;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}