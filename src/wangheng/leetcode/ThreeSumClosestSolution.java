package wangheng.leetcode;

import java.util.Arrays;

public class ThreeSumClosestSolution {
    public int threeSumClosest3(int[] num, int target) {
        if (num.length < 3) throw new IllegalArgumentException("The length of num is less than three!");
        
        Arrays.sort(num);
        int closestSum = num[0] + num[1] + num[2];
        
        for (int i = 0; i < num.length; i++) {
            int l = i+1;
            int r = num.length-1;
            while (l < r) {
                int sum = num[i] + num[l] + num[r];
                
                if (sum == target) return sum;
                
                if (Math.abs(sum-target) < Math.abs(closestSum-target)) closestSum = sum;
                
                if (sum <= target) {
                    do {
                        l++;
                    } while (l < num.length && num[l] == num[l-1]);
                }
                if (sum >= target) {
                    do {
                        r--;
                    } while (r >= 0 && num[r] == num[r+1]);
                }
            }
            
            while (i+1 < num.length && num[i+1] == num[i]) i++;
        }
        
        return closestSum;
    }

    public int threeSumClosest(int[] num, int target) {
        if (num.length < 3)
            return 0;
        java.util.Arrays.sort(num);
        int closestTarget = num[0] + num[1] + num[2];
        int closestDiff = diff(target, closestTarget);
        if (closestDiff == 0)
            return closestTarget;
        for (int i = 0; i < num.length - 2; i++) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                int diff = diff(sum, target);
                if (diff < closestDiff) {
                    closestDiff = diff;
                    closestTarget = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return closestTarget;
    }

    private int diff(int a, int b) {
        return a > b ? a - b : b - a;
        // return Math.abs(a-b);
    }

}
