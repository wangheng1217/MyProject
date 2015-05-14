package wangheng.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// greedy
public class ThreeSumSolution {
    public List<List<Integer>> threeSum2(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            int l = i+1, r = num.length-1;
            while (l < r) {
                int sum = num[i] + num[l] + num[r];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[l]);
                    list.add(num[r]);
                    result.add(list);
                }
                if (sum <= 0) {
                    do {
                        l++;
                    } while (l < num.length && num[l] == num[l-1]);
                }
                if (sum >= 0) {
                    do {
                        r--;
                    } while (r >= 0 && num[r] == num[r+1]);
                }
            }
            
            while (i+1 < num.length && num[i+1] == num[i]) i++;
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        java.util.Arrays.sort(num);

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < num.length - 2; i++) {
            if (i >= 1 && num[i] == num[i - 1])
                continue;
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                if (num[j] + num[k] < -num[i]) {
                    j++;
                } else if (num[j] + num[k] > -num[i]) {
                    k--;
                } else {
                    ArrayList<Integer> intList = new ArrayList<Integer>(3);
                    intList.add(0, num[i]);
                    intList.add(1, num[j]);
                    intList.add(2, num[k]);
                    list.add(intList);
                    j++;
                    while (j < k && num[j] == num[j - 1])
                        j++;
                    k--;
                    while (k > j && num[k] == num[k + 1])
                        k--;
                }
            }
        }
        return list;
    }
}
