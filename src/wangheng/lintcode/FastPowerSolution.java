package wangheng.lintcode;

import java.util.ArrayList;
import java.util.List;

public class FastPowerSolution {
    
    public static void main(String[] args) {
        FastPowerSolution solution = new FastPowerSolution();
        System.out.println(solution.fastPower(2, 2147483647, 2147483647));
    }
    
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        return fastPowerL(a, b, n);
        
    }
    
    private int fastPowerL(long a, long b, int n) {
        if (b < 0) return fastPowerL(a, -b, n);
        if (a < 0) return fastPowerL(-a, b, n) * (n%2 == 0 ? 1 : -1);
        if (a == 0 || b == 1) return 0;
        if (a == 1 || n == 0) return 1;
        
        List<Long> list = new ArrayList<Long>();
        for (long i = 1; i <= n; i<<=1) {
            long l;
            if (i == 1) {
                l = a%b;
            } else {
                long pre = list.get(list.size()-1);
                l = (pre*pre)%b;
            }
            if (l == 0) return 0;
            list.add(l);
        }
        
        long result = 1;
        for (int i = list.size()-1; i >= 0 && n > 0; i--) {
            if (n >= (1<<i)) {
                result = (result * list.get(i)) % b;
                n = n - (1 << i);
            }
        }
        
        return (int) result;
    }
}
