package wangheng.leetcode;

import java.util.ArrayList;
import java.util.List;

//DFS
public class GenerateParenthesesSolution {
    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<String>();
        char[] cArray = new char[n*2];
        dfs2(result, cArray, 0, 0, 0);
        return result;
    }
    
    private void dfs2(List<String> result, char[] cArray, int p, int lCount, int rCount) {
        if (p == cArray.length) {
            result.add(new String(cArray));
            return;
        }
        
        if (lCount < cArray.length/2) {
            cArray[p] = '(';
            dfs(result, cArray, p+1, lCount+1, rCount);
        }
        
        if (rCount < lCount) {
            cArray[p] = ')';
            dfs(result, cArray, p+1, lCount, rCount+1);
        }
    }

    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        // dfs("", 2 * n, list);
        dfs2("", 0, list, 0, 0, n);
        return list;
    }
    
    private void dfs(List<String> result, char[] c, int i, int openCount, int closeCount) {
        if (i == c.length-1) {
            c[i] = ')';
            String s = new String(c);
            result.add(s);
            return;
        }
        
        if (openCount == closeCount) {
            c[i] = '(';
            dfs(result, c, i+1, openCount+1, closeCount);
        } else {
            // openCount > closeCount
            if (openCount == c.length/2) {
                c[i] = ')';
                dfs(result, c, i+1, openCount, closeCount+1);
            } else {
                // openCount < c.length/2
                c[i] = '(';
                dfs(result, c, i+1, openCount+1, closeCount);
                
                c[i] = ')';
                dfs(result, c, i+1, openCount, closeCount+1);
            }
        }
    }

    private void dfs2(String s, int depth, ArrayList<String> list, int left,
            int right, int total) {
        if (depth == 2 * total) {
            list.add(s);
            return;
        }
        if (left == right)
            dfs2(s + "(", depth + 1, list, left + 1, right, total);
        else if (left > right) {
            if (left < total)
                dfs2(s + "(", depth + 1, list, left + 1, right, total);
            dfs2(s + ")", depth + 1, list, left, right + 1, total);
        }
    }

    private void dfs(String s, int depth, ArrayList<String> list) {
        if (depth == 0) {
            if (isValid(s)) {
                list.add(s);
            }
            return;
        }
        String s1 = s + "(";
        dfs(s1, depth - 1, list);
        String s2 = s + ")";
        dfs(s2, depth - 1, list);
    }

    public boolean isValid(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.empty())
                    return false;
                if (stack.pop() != '(')
                    return false;
            }
        }
        return stack.empty();
    }

}
