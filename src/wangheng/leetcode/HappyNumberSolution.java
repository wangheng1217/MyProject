package wangheng.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumberSolution {
    public boolean isHappy(int n) {
        if (n <= 0)
            return false;
        Set<Integer> set = new HashSet<Integer>();
        while (set.add(n)) {
            if (n == 1)
                return true;

            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum = sum + digit * digit;
                n = n / 10;
            }

            n = sum;
        }
        return false;
    }

    public boolean isHappy2(int n) {
        if (n <= 0)
            return false;
        while (true) {
            if (n == 1)
                return true;
            if (n == 4)
                return false;

            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum = sum + digit * digit;
                n = n / 10;
            }

            n = sum;
        }
    }

}
