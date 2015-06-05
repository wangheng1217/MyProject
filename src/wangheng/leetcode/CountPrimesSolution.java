package wangheng.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountPrimesSolution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i*i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i*i; j < n; j+=i) {
                isPrime[j] = false;
            }
        }
        
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        
        return count;
    }

    public int countPrimes2(int n) {
        List<Integer> primeList = new ArrayList<Integer>();
        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int prime : primeList) {
                if (prime*prime > i) break;
                if (i%prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primeList.add(i);
        }
        return primeList.size();
    }

}
