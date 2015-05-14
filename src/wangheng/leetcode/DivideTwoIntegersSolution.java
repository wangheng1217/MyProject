package wangheng.leetcode;

public class DivideTwoIntegersSolution {

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegersSolution().divide2(2147483647, 1));
    }
    
    // use long value to avoid overflow
    public int divide2(int dividend, int divisor) {
        if (divisor == 0) throw new IllegalArgumentException("divisor cannot be zero!");
        if (dividend == 0) return 0;

        boolean negative = (dividend > 0) ^ (divisor > 0);
        
        long a = dividend;
        long b = divisor;
        
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        
        int count = 0;
        while (b <= a) {
            b = b << 1;
            count++;
        }
        
        if (count > 0) b = b >> 1;
        int result = 0;
        for (int i = count-1; i >= 0; i--) {
            if (a >= b) {
                result = result + (1 << i);
                a = a - b;
            }
            b = b >> 1;
        }
        
        return (negative ? -result : result);
    }

    // this is wrong! infinite loop because of overflow
    public int divide(int dividend, int divisor) {
        boolean sign = true;
        if (dividend < 0) {
            dividend = -dividend;
            sign = !sign;
        }
        if (divisor < 0) {
            divisor = -divisor;
            sign = !sign;
        }

        int result = dividePositive(dividend, divisor);
        return sign ? result : -result;
    }

    private int dividePositive(int dividend, int divisor) {
        if (dividend < divisor)
            return 0;
        int count = 1;
        while (dividend >= divisor + divisor) {
            divisor = divisor + divisor;
            count++;
        }
        int result = 0;
        for (int i = count; i > 0; i--) {
            if (dividend >= divisor) {
                result = result + (1 << (i-1));
                dividend = dividend - divisor;
            }
            divisor>>=1;
        }
        return result;
    }

}
