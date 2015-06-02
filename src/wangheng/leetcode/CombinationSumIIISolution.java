package wangheng.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIIISolution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0) throw new IllegalArgumentException();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(1, n, k, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void dfs(int curr, int target, int k, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            if (target == 0) {
                result.add(new ArrayList<Integer>(list));
            }
            return;
        }
        
        for (int i = curr; i <= target && i <= 9; i++) {
            list.add(i);
            dfs(i+1, target-i, k, list, result);
            list.remove(list.size()-1);
        }
    }
}
