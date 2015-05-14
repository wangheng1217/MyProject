package wangheng.others.dp;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-14-variations-of-lis/
 */
public class BuildingBridges {

    @Test
    public void test() {
        BuildingBridges solution = new BuildingBridges();
        assertEquals(5, solution.maxPairs(new int[] { 8, 1, 4, 3, 5, 2, 6, 7 }, new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
    }

    public int maxPairs(int[] a, int[] b) {
        int[][] dp = new int[a.length + 1][b.length + 1];
        for (int i = 0; i <= a.length; i++) {
            for (int j = 0; j <= b.length; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    if (a[i - 1] == b[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[a.length][b.length];
    }
}
