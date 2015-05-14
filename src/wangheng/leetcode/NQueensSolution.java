package wangheng.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensSolution {
    public List<String[]> solveNQueens2(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, new ArrayList<Integer>(), n);
        return convert(result);
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> list, int n) {
        if (list.size() == n) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        int row = list.size();
        for (int col = 0; col < n; col++) {
            boolean valid = true;
            for (int i = 0; i < list.size(); i++) {
                if (col == list.get(i) || Math.abs(row-i) == Math.abs(col-list.get(i))) {
                    valid = false;
                    break;
                }
            }
            
            if (valid) {
                list.add(col);
                dfs(result, list, n);
                list.remove(list.size()-1);
            }
        }
    }
    
    private List<String[]> convert(List<List<Integer>> result) {
        List<String[]> strList = new ArrayList<String[]>();
        for (List<Integer> intList : result) {
            String[] strArray = new String[intList.size()];
            for (int i = 0; i < intList.size(); i++) {
                char[] cArray = new char[intList.size()];
                Arrays.fill(cArray, '.');
                cArray[intList.get(i)] = 'Q';
                strArray[i] = new String(cArray);
            }
            strList.add(strArray);
        }
        return strList;
    }

    public static void main(String[] args) {
        NQueensSolution solution = new NQueensSolution();
        ArrayList<String[]> res = solution.solveNQueens(12);
        for (int i = 0; i < res.size(); i++) {
            String[] strs = res.get(i);
            for (int j = 0; j < strs.length; j++) {
                System.out.println(strs[j]);
            }
            System.out.println();
        }
    }

    public ArrayList<String[]> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<String[]>();
        }

        ArrayList<String[]> res = new ArrayList<String[]>();
        Integer[] sol = new Integer[n];
        dfs(sol, 1, res, n);
        return res;
    }

    private void dfs(Integer[] sol, int depth, ArrayList<String[]> res, int n) {
        if (depth > n) {
            if (isValid(sol, depth - 2)) {
                res.add(format(sol));
            }
        } else {
            if (isValid(sol, depth - 2)) {
                for (int i = 0; i < n; i++) {
                    sol[depth - 1] = i;
                    dfs(sol, depth + 1, res, n);
                }
            }
        }
    }

    private boolean isValid(Integer[] sol, int pos) {
        for (int i = 0; i < pos; i++) {
            if (sol[pos] == sol[i])
                return false;
            if ((sol[pos] - sol[i]) == (pos - i))
                return false;
            if ((sol[pos] - sol[i]) == (i - pos))
                return false;
        }
        return true;
    }

    private String[] format(Integer[] intSol) {
        int n = intSol.length;
        String[] strSol = new String[n];
        for (int j = 0; j < n; j++) {
            int k = intSol[j];
            StringBuffer sb = new StringBuffer();
            for (int l = 0; l < n; l++) {
                if (l != k) {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }
            strSol[j] = sb.toString();
        }
        return strSol;
    }

}
