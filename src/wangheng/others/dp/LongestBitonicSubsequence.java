package wangheng.others.dp;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/
 */
public class LongestBitonicSubsequence {

    @Test
    public void test() {
        LongestBitonicSubsequence solution = new LongestBitonicSubsequence();
        assertEquals(6, solution.longestBitonicSubsequence(new int[] { 1, 11, 2, 10, 4, 5, 2, 1 }));
        assertEquals(5, solution.longestBitonicSubsequence(new int[] { 12, 11, 40, 5, 3, 1 }));
        assertEquals(5, solution.longestBitonicSubsequence(new int[] { 80, 60, 30, 40, 20, 10 }));
    }

    public int longestBitonicSubsequence(int[] array) {
        if (array.length == 0)
            return 0;
        int[] incr = new int[array.length];
        int[] decr = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            incr[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && incr[i] < incr[j] + 1) {
                    incr[i] = incr[j] + 1;
                }
            }
        }

        int maxLength = Integer.MIN_VALUE;
        for (int i = array.length - 1; i >= 0; i--) {
            decr[i] = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j] && decr[i] < decr[j] + 1) {
                    decr[i] = decr[j] + 1;
                }
            }
            maxLength = Math.max(maxLength, incr[i] + decr[i] - 1);
        }

        return maxLength;
    }
}
