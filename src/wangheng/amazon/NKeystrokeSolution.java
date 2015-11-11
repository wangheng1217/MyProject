package wangheng.amazon;

/*
 * http://www.geeksforgeeks.org/amazon-interview-experience-192/
 * Imagine you have four operations. ¡®K¡¯ (types k on screen), ¡®select all¡¯, ¡®copy¡¯, ¡®paste¡¯. Find out maximum number of K¡¯s possible for given number of keystrokes.
 */
public class NKeystrokeSolution {
    public int getMaxK(int n) {
        if (n <= 3)
            return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            int count = i;
            // for (int j = Math.max(1, i-6); j <= i-3; j++) {
            for (int j = 1; j <= i - 3; j++) {
                count = Math.max(count, dp[j] * (i - j - 1));
            }
            dp[i] = count;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        NKeystrokeSolution solution = new NKeystrokeSolution();
        for (int i = 1; i <= 50; i++) {
            System.out.println(solution.getMaxK(i));
        }
    }
}
