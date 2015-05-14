package wangheng.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class MinimumWindowSubstringSolution {
    public String minWindow2(String S, String T) {
        if (T.length() == 0) return "";
        
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();
        Map<Character, LinkedList<Integer>> posMap = new HashMap<Character, LinkedList<Integer>>();
        
        for (int i = 0; i < T.length(); i++) {
            Integer count = countMap.get(T.charAt(i));
            if (count == null) countMap.put(T.charAt(i), 1);
            else countMap.put(T.charAt(i), count+1);
        }
        
        boolean found = false;
        int foundCount = 0;
        int start = -1;
        String minWindow = "";
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (countMap.get(c) == null) continue;
            if (start == -1) start = i;

            if (posMap.get(c) != null && posMap.get(c).size() == countMap.get(c)) {

                LinkedList<Integer> posList = posMap.get(c);
                posList.removeFirst();
                posList.add(i);
                
                if (S.charAt(start) == S.charAt(i)) {
                    start = getStart(posMap);
                    
                    if (found) {
                        String window = S.substring(start, i+1);
                        if (window.length() < minWindow.length()) minWindow = window;
                    }
                }
                
            } else {
                LinkedList<Integer> posList = posMap.get(c);
                if (posList == null) {
                    posList = new LinkedList<Integer>();
                    posMap.put(c, posList);
                }
                
                posList.add(i);
                
                if (posList.size() == countMap.get(c)) {
                    foundCount++;
                    if (foundCount == countMap.size()) {
                        found = true;
                        minWindow = S.substring(start, i+1);
                    }
                }
                
            }
            
        }
        
        return minWindow;
    }
    
    private int getStart(Map<Character, LinkedList<Integer>> posMap) {
        int start = Integer.MAX_VALUE;
        Iterator<LinkedList<Integer>> ite = posMap.values().iterator();
        while (ite.hasNext()) {
            LinkedList<Integer> list = ite.next();
            start = Math.min(start, list.get(0));
        }
        return start;
    }

    public static void main(String[] args) {
        MinimumWindowSubstringSolution solution = new MinimumWindowSubstringSolution();
        String s = "ADOBECODEBANC";
        String t = "ABBC";
        System.out.println(solution.minWindow(s, t));
    }

    public String minWindow(String S, String T) {
        if (T == null || T.equals(""))
            return "";

        HashMap<Character, LinkedList<Integer>> map = new HashMap<Character, LinkedList<Integer>>();
        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
            map.put(T.charAt(i), new LinkedList<Integer>());
            if (countMap.containsKey(T.charAt(i))) {
                countMap.put(T.charAt(i), countMap.get(T.charAt(i)) + 1);
            } else {
                countMap.put(T.charAt(i), 1);
            }
        }

        int found = 0;
        int minLength = -1;
        String minWindow = "";
        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(S.charAt(i))) {
                if (map.get(S.charAt(i)).size() < countMap.get(S.charAt(i))) {
                    map.get(S.charAt(i)).add(i);
                    found++;
                } else {
                    map.get(S.charAt(i)).pollFirst();
                    map.get(S.charAt(i)).add(i);
                }

                if (found == T.length()) {
                    int start = minValue(map);
                    int length = i - start + 1;
                    if (minLength == -1) {
                        minLength = length;
                        minWindow = S.substring(start, i + 1);
                    } else {
                        if (length < minLength) {
                            minLength = length;
                            minWindow = S.substring(start, i + 1);
                        }
                    }
                    map.get(S.charAt(start)).pollFirst();
                    found--;
                }
            }
        }
        return minWindow;
    }

    private int minValue(HashMap<Character, LinkedList<Integer>> map) {
        Iterator<LinkedList<Integer>> ite = map.values().iterator();
        int min = Integer.MAX_VALUE;
        while (ite.hasNext()) {
            min = min(min, ite.next().peekFirst());
        }
        return min;
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }
}
