package wangheng.others.dp;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * 
 * Given a value N, if we want to make change for N cents, 
 * and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
 * how many ways can we make the change? The order of coins doesn’t matter.
 * 
 * To count total number solutions, we can divide all set solutions in two sets.
 * 1) Solutions that do not contain mth coin (or Sm).
 * 2) Solutions that contain at least one Sm.
 * Let count(S[], m, n) be the function to count the number of solutions, 
 * then it can be written as sum of count(S[], m-1, n) and count(S[], m, n-Sm).
 */
public class CoinChangeSolution {
    
    @Test
    public void test() {
        CoinChangeSolution solution = new CoinChangeSolution();
        assertEquals(4, solution.count(new int[]{1, 2, 3}, 4));
        assertEquals(5, solution.count(new int[]{2, 5, 3, 6}, 10));
    }
    
    public int count(int[] S, int n) {
        int m = S.length;
        int[][] dp = new int[m+1][n+1];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) dp[i][j] = 0;
                else if (j == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i-1][j];
                    if (j-S[i-1] >= 0) {
                        dp[i][j] = dp[i][j] + dp[i][j-S[i-1]];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}
