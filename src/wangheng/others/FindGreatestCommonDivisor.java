package wangheng.others;

public class FindGreatestCommonDivisor {
    public int findGcd(int a, int b){
        return (a == 0 || b == 0) ? a + b : findGcd(b, a % b);
    }
}
