package wangheng.leetcode;

public class NumberOf1BitsSolution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            // "n &= n - 1" is used to delete the right "1" of n
            n &= n - 1;
            count++;
        }
        return count;
    }

    // you need to treat n as an unsigned value
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count++;
            n>>>=1;
        }
        return count;
    }

}
