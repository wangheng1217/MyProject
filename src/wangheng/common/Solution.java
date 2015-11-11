package wangheng.common;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    
    Map<Character, Node> map;
    Node dummyHead, dummyTail;
    
    class LRUMap extends LinkedHashMap<Character, Integer> {
        int start = 0;
        int maxLength = 0;
        int size;
        
        LRUMap(int size) {
            this.size = size;
        }
    }
    
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;
        if (k >= s.length()) return s.length();
        
        float LOAD_FACTOR = 0.75f;
        int initialCapacity = (int) Math.ceil(k / LOAD_FACTOR) + 1;
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>(initialCapacity, LOAD_FACTOR, true);
        
        int maxLength = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
            if (map.size() > k) {
                maxLength = Math.max(maxLength, i-start);
                start = map.values().iterator().next() + 1;
                map.remove(map.keySet().iterator().next());
            }
        }
        maxLength = Math.max(maxLength, s.length()-start);
        return maxLength;
    }
    
    private void remove(Node node) {
        map.remove(node.c);
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    private void add(Node node) {
        map.put(node.c, node);
        dummyTail.pre.next = node;
        node.pre = dummyTail.pre;
        node.next = dummyTail;
        dummyTail.pre = node;
    }
}

class Node {
    char c;
    int pos;
    Node pre;
    Node next;
    Node(char c, int pos) {
        this.c = c;
        this.pos = pos;
    }
}
