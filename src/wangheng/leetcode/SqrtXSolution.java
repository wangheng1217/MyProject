package wangheng.leetcode;

//TODO use division to prevent overflow
public class SqrtXSolution {
    public int sqrt4(int x) {
        if (x < 0) throw new IllegalArgumentException("x cannot be negative!");
        if (x < 2) return x;
        
        int l = 1, r = x;
        while (l <= r) {
            if (l == r) return l;
            if (l+1 == r) {
                if (r <= x/r) return r;
                else return l;
            }
            
            int mid = l + (r-l)/2;
            
            if (mid == x/mid) return mid;
            
            if (mid < x/mid) l = mid;
            else r = mid;
        }
        
        return 0;
    }
    
    public int sqrt3(int x) {
        if (x < 0) throw new IllegalArgumentException("x cannot be negative!");
        if (x < 2) return x;
        
        int l = 1, r = x;
        while ((l << 1) <= (r >> 1)) {
            l <<= 1;
            r >>= 1;
        }
        
        // CANNOT use "l*l <= x", may cause overflow
        while (l <= x/l) {
            l++;
        }
        
        return l-1;
    }

    public static void main(String[] args) {
        SqrtXSolution solution = new SqrtXSolution();
        for (int i = 0; i <= 100; i++) {
            System.out.println("sqrt(" + i + ") = " + solution.sqrt2(i));
        }
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(solution.sqrt2(2147395600));
        System.out.println(solution.sqrt2(2147483647));
    }
    
    public int sqrt2(int x) {
        if (x < 0)
            return -1;

        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        
        int start = 1, end = x;
        while(end-start > 1) {
            int mid = start + (end-start)/2;
            
            int division = x/mid;
            if(mid == division) return mid;
            else if(mid > division) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        
        return start;
    }

    public int sqrt(int x) {
        if (x < 0)
            return -1;

        if (x == 0)
            return 0;
        if (x == 1)
            return 1;

        int start = 1, end = x;
        while (start <= end) {
            // start + end might
            int n = (int) (((long) start + (long) end) / 2);

            // n square might overflow
            long sqrL = (long) n * (long) n;
            long sqrL2 = sqrL + 2 * (long) n + 1;

            if (sqrL <= x && sqrL2 > x) {
                return n;
            } else {
                if (sqrL > x) {
                    end = n - 1;
                } else if (sqrL2 <= x) {
                    start = n + 1;
                }
            }
        }

        return -1;
    }

}
