package wangheng.leetcode;

import java.util.PriorityQueue;

public class KthLargestElementInAnArraySolution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);
        for (int n : nums) {
            if (heap.size() < k) heap.offer(n);
            else if (heap.size() == k && n > heap.peek()) {
                heap.poll();
                heap.offer(n);
            }
        }
        return heap.peek();
    }
}
