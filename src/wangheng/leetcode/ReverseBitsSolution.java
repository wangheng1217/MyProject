package wangheng.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ReverseBitsSolution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++, n>>>=1) {
            result = (result << 1) | (n & 1);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(new ReverseBitsSolution().reverseBits2(1));
    }
    
    // optimization with cache
    
    private Map<Byte, Integer> cache = new HashMap<Byte, Integer>();
    
    public int reverseBits2(int n) {
        int result = 0;
        for (int i = 0; i < 4; i++, n>>>=8) {
            result = (result << 8) | reverseByte((byte) (n & 0xFF));
        }
        
        return result;
    }
    
    private int reverseByte(byte b) {
        Integer result = cache.get(b);
        if (result != null) return result;
        
        byte by = b;
        
        result = 0;
        for (int i = 0; i < 8; i++, by>>>=1) {
            result = (result << 1) | (by & 1);
        }
        
        cache.put(b, result);
        
        return result;
    }
    
}