package wangheng.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: DFS
public class LetterCombinationsSolution {
    public List<String> letterCombinations2(String digits) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        map.put('0', Arrays.asList(' '));
        dfs(digits, 0, result, sb, map);
        return result;
    }
    
    private void dfs(String digits, int p, List<String> result, StringBuilder sb, Map<Character, List<Character>> map) {
        if (p == digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        List<Character> list = map.get(digits.charAt(p));
        if (list == null) {
            dfs(digits, p+1, result, sb, map);
        } else {
            for (Character c : list) {
                sb.append(c);
                dfs(digits, p+1, result, sb, map);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    java.util.HashMap<Character, ArrayList<String>> map = initMap();

    // DFS
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        dfs(res, "", 0, digits);
        return res;
    }

    private void dfs(ArrayList<String> res, String s, int n, String digits) {
        if (n == digits.length()) {
            res.add(s);
            return;
        }

        ArrayList<String> list = map.get(digits.charAt(n));
        if (list.size() == 0) {
            dfs(res, s, n + 1, digits);
        }
        for (int i = 0; i < list.size(); i++) {
            dfs(res, s + list.get(i), n + 1, digits);
        }
    }

    /*
    // recursion
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<String>();
        if (digits == null)
            return list;
        if (digits.length() == 0) {
            list.add("");
            return list;
        }
        if (digits.length() == 1)
            return map.get(digits.charAt(0));
        ArrayList<String> list1 = map.get(digits.charAt(0));
        ArrayList<String> list2 = letterCombinations(digits.substring(1,
                digits.length()));
        if (list1.size() == 0)
            return list2;
        if (list2.size() == 0)
            return list1;
        for (int i = 0; i < list1.size(); i++) {
            String a = list1.get(i);
            for (int j = 0; j < list2.size(); j++) {
                String b = list2.get(j);
                list.add(a + b);
            }
        }
        return list;
    }
    */

    private java.util.HashMap<Character, ArrayList<String>> initMap() {
        ArrayList<String> list0 = new ArrayList<String>();
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<String> list3 = new ArrayList<String>();
        ArrayList<String> list4 = new ArrayList<String>();
        ArrayList<String> list5 = new ArrayList<String>();
        ArrayList<String> list6 = new ArrayList<String>();
        ArrayList<String> list7 = new ArrayList<String>();
        ArrayList<String> list8 = new ArrayList<String>();
        ArrayList<String> list9 = new ArrayList<String>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list3.add("d");
        list3.add("e");
        list3.add("f");
        list4.add("g");
        list4.add("h");
        list4.add("i");
        list5.add("j");
        list5.add("k");
        list5.add("l");
        list6.add("m");
        list6.add("n");
        list6.add("o");
        list7.add("p");
        list7.add("q");
        list7.add("r");
        list7.add("s");
        list8.add("t");
        list8.add("u");
        list8.add("v");
        list9.add("w");
        list9.add("x");
        list9.add("y");
        list9.add("z");
        java.util.HashMap<Character, ArrayList<String>> hashMap = new java.util.HashMap<Character, ArrayList<String>>();
        hashMap.put('0', list0);
        hashMap.put('1', list1);
        hashMap.put('2', list2);
        hashMap.put('3', list3);
        hashMap.put('4', list4);
        hashMap.put('5', list5);
        hashMap.put('6', list6);
        hashMap.put('7', list7);
        hashMap.put('8', list8);
        hashMap.put('9', list9);
        return hashMap;
    }

}
