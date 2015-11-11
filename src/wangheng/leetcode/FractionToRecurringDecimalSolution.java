package wangheng.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FractionToRecurringDecimalSolution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        if (denominator == 0) throw new IllegalArgumentException("denominator cannot be zero");
        return fractionToDecimalLong(numerator, denominator);
    }
    
    private String fractionToDecimalLong(long numerator, long denominator) {
        if (numerator < 0 && denominator < 0) return fractionToDecimalLong(-numerator, -denominator);
        if (numerator < 0 || denominator < 0) return "-" + fractionToDecimalLong(Math.abs(numerator), Math.abs(denominator));
        
        long n = numerator/denominator;
        long mod = numerator%denominator;
        if (mod == 0) return ""+n;
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        int i = 0;
        while (mod != 0 && !map.containsKey(mod)) {
            map.put(mod, i);
            mod = mod * 10;
            list.add((int) (mod/denominator));
            mod = mod%denominator;
            i++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(n).append('.');
        if (mod == 0) {
            for (Integer k : list) {
                sb.append(k);
            }
        } else {
            i = map.get(mod);
            for (int j = 0; j < list.size(); j++) {
                if (j == i) sb.append('(');
                sb.append(list.get(j));
            }
            sb.append(')');
        }
        
        return sb.toString();
    }
}
