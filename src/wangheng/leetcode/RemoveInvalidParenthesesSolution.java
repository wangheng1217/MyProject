package wangheng.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Heng Wang on 11/5/2015.
 */
public class RemoveInvalidParenthesesSolution {
    public List<String> removeInvalidParentheses(String s) {
        int count = 0, openN = 0, closeN = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count == 0) closeN++;
                else count--;
            }
        }
        openN = count;
        count = 0;

        if (openN == 0 && closeN == 0) return Arrays.asList(s);

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        dfs(s.toCharArray(), 0, count, openN, closeN, result, sb);

        return result;
    }

    private void dfs(char[] s, int p, int count, int openN, int closeN, List<String> result, StringBuilder sb) {
        if (count < 0) return;
        if (p == s.length) {
            if (openN == 0 && closeN == 0) {
                result.add(sb.toString());
            }
            return;
        }

        if (s[p] != '(' && s[p] != ')') {
            sb.append(s[p]);
            dfs(s, p+1, count, openN, closeN, result, sb);
            sb.deleteCharAt(sb.length()-1);
        } else if (s[p] == '(') {
            int i = 1;
            while (p+i < s.length && s[p+i] == '(') i++;
            sb.append(s, p, i);
            dfs(s, p+i, count+i, openN, closeN, result, sb);
            sb.delete(sb.length()-i, sb.length());

            if (openN > 0) {
                dfs(s, p+1, count, openN-1, closeN, result, sb);
            }
        } else {
            int i = 1;
            while (p+i < s.length && s[p+i] == ')') i++;
            sb.append(s, p, i);
            dfs(s, p+i, count-i, openN, closeN, result, sb);
            sb.delete(sb.length()-i, sb.length());

            if (closeN > 0) {
                dfs(s, p+1, count, openN, closeN-1, result, sb);
            }
        }
    }
}
