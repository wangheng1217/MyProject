package wangheng.leetcode;

public class NextPermutationSolution {
    public void nextPermutation3(int[] nums) {
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                replace(nums, i);
                reverse(nums, i+1);
                return;
            }
        }
        
        reverse(nums, 0);
    }
    
    private void replace(int[] nums, int pos) {
        for (int i = nums.length-1; i > pos; i--) {
            if (nums[pos] < nums[i]) {
                swap(nums, pos, i);
                break;
            }
        }
    }
    
    private void replace2(int[] nums, int pos) {
        int l = pos+1, r = nums.length-1;
        while (l < r) {
            int mid = (l+r)/2;
            if (nums[mid] > nums[pos] && nums[mid+1] <= nums[pos]) {
                swap(nums, pos, mid);
                return;
            }
            if (nums[mid] > nums[pos]) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        swap(nums, pos, l);
    }
   
    private void reverse(int[] nums, int pos) {
        for (int i = 0; pos+i < nums.length-1-i; i++) {
            swap(nums, pos+i, nums.length-1-i);
        }
    }

    public void nextPermutation2(int[] num) {
        boolean found = false;
        for (int i = num.length-2; i >= 0; i--) {
            if (num[i] >= num[i+1]) continue;
            else {
                // num[i] < num[i+1]
                for (int j = num.length-1; j > i; j--) {
                    if (num[j] <= num[i]) continue;
                    else {
                        swap(num, i, j);
                        reverse(num, i+1, num.length-1);
                        break;
                    }
                }
                found = true;
                break;
            }
        }
        if (!found) reverse(num, 0, num.length-1);
    }
    
    private void reverse(int[] num, int i, int j) {
        while (i < j) {
            swap(num, i, j);
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] num) {
        for (int i = num.length - 1; i >= 0; i--) {
            for (int j = num.length - 1; j > i; j--) {
                if (num[i] < num[j]) {
                    swap(num, i, j);
                    int k = 0;
                    while (i + 1 + k < num.length - 1 - k) {
                        swap(num, i + 1 + k, num.length - 1 - k);
                        k++;
                    }
                    return;
                }
            }
        }

        int k = 0;
        while (k < num.length - 1 - k) {
            swap(num, k, num.length - 1 - k);
            k++;
        }
    }

    private void swap(int[] num, int a, int b) {
        num[a] = num[a] + num[b];
        num[b] = num[a] - num[b];
        num[a] = num[a] - num[b];
    }

}
