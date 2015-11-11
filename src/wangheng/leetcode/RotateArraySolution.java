package wangheng.leetcode;

public class RotateArraySolution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        if (k == 0) return;
        
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            nums[l] ^= nums[r];
            nums[r] ^= nums[l];
            nums[l] ^= nums[r];
            l++;
            r--;
        }
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        if (k == 0) return;
        
        int count = 0;
        
        for (int initPos = n-1; initPos >= 0 && count < n; initPos--) {
            int initValue = nums[initPos];
            int currPos = initPos;
            int nextPos = currPos-k >= 0 ? currPos-k : n+currPos-k;
            while (nextPos != initPos) {
                nums[currPos] = nums[nextPos];
                count++;
                currPos = nextPos;
                nextPos = currPos-k >= 0 ? currPos-k : n+currPos-k;
            }
            nums[currPos] = initValue;
            count++;
        }
    }

}
