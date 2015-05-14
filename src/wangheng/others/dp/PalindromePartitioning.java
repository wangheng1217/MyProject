package wangheng.others.dp;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
 */
public class PalindromePartitioning {

    @Test
    public void test() {
        PalindromePartitioning solution = new PalindromePartitioning();
        assertEquals(3, solution.minCut("ababbbabbababa"));
        assertEquals(0, solution.minCut("aaaaaaaaaaaaaa"));
        assertEquals(13, solution.minCut("abcdefghijklmn"));
    }

    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalin = new boolean[n][n];
        int[][] minCut = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j)
                    isPalin[i][j] = true;
                else {
                    if (s.charAt(i) == s.charAt(j) && (i + 1 == j || isPalin[i + 1][j - 1])) {
                        isPalin[i][j] = true;
                    }
                }

                if (isPalin[i][j])
                    minCut[i][j] = 0;
                else {
                    int minC = Integer.MAX_VALUE;
                    for (int k = 0; i + k + 1 <= j; k++) {
                        minC = Math.min(minC, minCut[i][i + k] + minCut[i + k + 1][j] + 1);
                    }
                    minCut[i][j] = minC;
                }
            }
        }

        return minCut[0][n - 1];
    }

    public int minCut2(String s) {
        int n = s.length();
        int[][] minCut = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j || (s.charAt(i) == s.charAt(j) && (i + 1 == j || minCut[i + 1][j - 1] == 0)))
                    minCut[i][j] = 0;
                else {
                    int minC = Integer.MAX_VALUE;
                    for (int k = 0; i + k + 1 <= j; k++) {
                        minC = Math.min(minC, minCut[i][i + k] + minCut[i + k + 1][j] + 1);
                    }
                    minCut[i][j] = minC;
                }
            }
        }

        return minCut[0][n - 1];
    }

}
