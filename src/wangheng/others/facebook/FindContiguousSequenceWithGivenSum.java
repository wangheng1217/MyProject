package wangheng.others.facebook;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 * http://www.mitbbs.com/article_t1/JobHunting/32838067_0_1.html
 * 
 * 1) 给个数组seq， 和一个total，找 if there is a contiguous sequence in seq 
which sums to total.
都是正数， 第一次没注意contiguous，给了个back tracking的解法。然后说是
contiguous， 给了
个维护窗口的解法，不过犯了个小错误。时间过去了半小时。。。
 */
public class FindContiguousSequenceWithGivenSum {
    // There is a O(n) solution.
    
    @Test
    public void test() {
        FindContiguousSequenceWithGivenSum solution = new FindContiguousSequenceWithGivenSum();
        
        assertTrue(solution.findSum(new int[]{1, 2, 3}, 2));
        assertTrue(solution.findSum(new int[]{1, 0, 3, 4, -2, 6, -7}, 2));
        assertTrue(solution.findSum(new int[]{1, 0, 3, -2}, 2));
        assertTrue(solution.findSum(new int[]{-1, 0, 3, -2}, 2));
        assertTrue(solution.findSum(new int[]{2, 0, 1, -2}, 2));
        assertTrue(solution.findSum(new int[]{2}, 2));
        assertFalse(solution.findSum(new int[]{}, 2));
        assertFalse(solution.findSum(new int[]{0, 1, 3, 4}, 2));
        assertFalse(solution.findSum(new int[]{3}, 2));
        assertFalse(solution.findSum(new int[]{-1, 4, 3, -2, 5, 1, -3}, 2));
    }
    
    public boolean findSum(int[] array, int target) {
        if (array.length == 0) return false;
        
        int[] sum = new int[array.length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) sum[i] = array[i];
            else sum[i] = sum[i-1] + array[i];
            
            if (sum[i] == target || map.containsKey(sum[i]-target)) return true;
            
            map.put(sum[i], i);
        }
        
        return false;
    }
}
