package wangheng.others.dp;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * http://www.geeksforgeeks.org/fundamentals-of-algorithms/
 * 
 * Given an array p[] which represents the chain of matrices such that the ith matrix Ai is of dimension p[i-1] x p[i]. 
 * We need to write a function MatrixChainOrder() that should return the minimum number 
 * of multiplications needed to multiply the chain.
 */
public class MatrixChainMultiplication {
    
    @Test
    public void test() {
        MatrixChainMultiplication solution = new MatrixChainMultiplication();
        assertEquals(26000, solution.minMultiplyCount(new int[]{40, 20, 30, 10, 30}));
        assertEquals(30000, solution.minMultiplyCount(new int[]{10, 20, 30, 40, 30}));
        assertEquals(6000, solution.minMultiplyCount(new int[]{10, 20, 30}));
    }
    
    public int minMultiplyCount(int[] p) {
        int m = p.length-1;
        int[][] dp = new int[m][m];
        
        for (int i = m-1; i >= 0; i--) {
            for (int j = i; j < m; j++) {
                if (i == j) dp[i][j] = 0;
                else {
                    int minCount = Integer.MAX_VALUE;
                    for (int k = 0; i+k+1 <= j; k++) {
                        minCount = Math.min(minCount, dp[i][i+k] + dp[i+k+1][j] + p[i]*p[i+k+1]*p[j+1]);
                    }
                    dp[i][j] = minCount;
                }
            }
        }
        
        return dp[0][m-1];
    }
}
