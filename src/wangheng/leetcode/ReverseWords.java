package wangheng.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {
    public String reverseWords(String s) {
        List<String> words = new ArrayList<String>();
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (start == -1) continue;
                words.add(s.substring(start, i));
                start = -1;
            } else {
                if (start == -1) start = i;
            }
        }
        if (start != -1) words.add(s.substring(start, s.length()));
        
        StringBuilder sb = new StringBuilder();
        for (int i = words.size()-1; i >= 0; i--) {
            sb.append(words.get(i));
            if (i > 0) sb.append(" ");
        }
        
        return sb.toString();
    }

}
