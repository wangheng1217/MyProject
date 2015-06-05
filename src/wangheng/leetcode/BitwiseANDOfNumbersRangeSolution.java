package wangheng.leetcode;

public class BitwiseANDOfNumbersRangeSolution {
    public int rangeBitwiseAnd(int m, int n) {
        int bit = 0;
        while (m != n) {
            m>>=1;
            n>>=1;
            bit++;
        }
        return m << bit;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        int result = 0;
        for (int bit = 1<<30; bit > 0; bit>>=1) {
            if ((m & bit) != (n & bit)) break;
            result = result | (m & bit);
        }
        return result;
    }

}
