package wangheng.leetcode;

public class FindPeakElementSolution {
    public int findPeakElement(int[] num) {
        int l = 0, r = num.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (num[mid] < num[mid + 1])
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    public int findPeakElement2(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int l = 0, r = nums.length - 1;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1])
                return mid;
            if (nums[mid] < nums[mid + 1])
                l = mid + 1;
            else
                r = mid - 1;
        }
        if (l == r)
            return l;
        else
            return nums[l] < nums[r] ? r : l;
    }

    public int findPeakElement3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i] > nums[i + 1])
                return i;
        }

        return -1;
    }

}
