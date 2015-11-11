package wangheng.leetcode;

public class SingleNumberIISolution {
    public int singleNumber(int[] A) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                sum = sum + ((A[j] >> i) & 1);
            }

            result = result | ((sum % 3) << i);
        }
        return result;
    }

}
