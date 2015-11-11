package wangheng.leetcode;

public class BestTimeToBuyAndSellStockIVSolution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1 || k == 0) return 0;
        
        int n = prices.length;
        if (k >= n/2) {
            int p = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1]) p = p + prices[i] - prices[i-1];
            }
            return p;
        }

        int[][] dp = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            int tmpMax = dp[i-1][0] - prices[0]; // -prices[0]
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j-1], tmpMax + prices[j]);
                tmpMax = Math.max(tmpMax, dp[i-1][j] - prices[j]);
            }
            
            /* simplified from the following code, keep the current max in the internal loop
            for (int j = 1; j < n; j++) {
                int maxP = dp[i][j-1];
                for (int m = 0; m < j; m++) {
                    maxP = Math.max(maxP, dp[i-1][m] + prices[j] - prices[m]);
                }
                dp[i][j] = maxP;
            }
             */
        }
        
        return dp[k][n-1];
    }

}
