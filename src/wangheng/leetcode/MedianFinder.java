package wangheng.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    Queue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i2 - i1;
        }
    });

    Queue<Integer> right = new PriorityQueue<>();

    // Adds a number into the data structure.
    public void addNum(int num) {
        /*
        if (right.isEmpty() || num <= right.peek()) {
            left.offer(num);
            if (left.size() - right.size() > 1) {
                right.offer(left.poll());
            }
        } else {
            right.offer(num);
            if (right.size() > left.size()) {
                left.offer(right.poll());
            }
        }
        */
        
        left.offer(num);
        right.offer(left.poll());
        if (left.size() < right.size()) left.offer(right.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (left.size() == 0)
            throw new RuntimeException("Input is empty.");

        if (left.size() > right.size())
            return left.peek();

        return ((double) left.peek() + right.peek()) / 2;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();