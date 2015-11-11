package wangheng.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicateIIISolution {

    // using bucket map, O(n) time, O(k) space
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0 || t < 0)
            return false;
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        for (int i = 0; i < nums.length; i++) {
            long bucket = ((long) nums[i] - Integer.MIN_VALUE) / ((long) t + 1);
            if (map.containsKey(bucket))
                return true;
            Integer pre = map.get(bucket - 1);
            if (pre != null && Math.abs(nums[i] - (long) pre) <= (long) t)
                return true;
            Integer next = map.get(bucket + 1);
            if (next != null && Math.abs((long) next - nums[i]) <= (long) t)
                return true;

            map.put(bucket, nums[i]);

            if (i >= k) {
                map.remove(((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1));
            }
        }
        return false;
    }

    // using TreeSet(binary search tree), O(nlgk) time, O(k) space
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (k <= 0 || t < 0)
            return false;

        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = set.floor(nums[i]);
            if (floor != null && Math.abs((long) floor - nums[i]) <= t)
                return true;
            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null && Math.abs((long) ceiling - nums[i]) <= t)
                return true;
            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }

}
