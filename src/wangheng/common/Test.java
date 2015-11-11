package wangheng.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test {

    private static final int[] PRIMES = new int[]{2, 3, 5, 7, 11 ,13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101, 107};

    private long hash(String s) {
        long hash = 1;
        for (int i = 0; i < s.length(); i++) {
            hash *= PRIMES[s.charAt(i) - 'a'];
        }
        return hash;
    }

    public static void main(String[] args) throws Exception {


//        int i = 1;
//        long l = 1;
//        System.out.println(i<<30);
//        System.out.println(i<<31);
//        System.out.println(i<<32);
//        System.out.println(l<<30);
//        System.out.println(l<<31);
//        System.out.println(l<<32);
//        
//        System.out.println(1<<31);
//        System.out.println(1L<<31);
//        
//        
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("a", "A");
//        map.put("b", "B");
//        Iterator<String> ite = map.keySet().iterator();
//        while (ite.hasNext()) {
//            String key = ite.next();
//            System.out.println(key + " : " + map.get(key));
//        }
//        
//        map.put("a", "C");
//        ite = map.keySet().iterator();
//        while (ite.hasNext()) {
//            String key = ite.next();
//            System.out.println(key + " : " + map.get(key));
//        }
//        
//        System.out.println(-(5/2));
//        System.out.println((-5)/2);
//        System.out.println(-5/2);
//        
//        
//        System.out.println("1".split("\\.").length);
//        
//        int[] num = new int[2];
//        for (int n : num) {
//            //
//        }
//        
//        System.out.println(~0);
//        
//        int PRIME = 33;
//
//        char[] key = "ubuntu".toCharArray();
//        int HASH_SIZE = 1007;
//
//        long sum = 0;
//        for (char c : key) {
//            sum = sum * PRIME + ((int) c);
//        }
//        System.out.println(sum % HASH_SIZE);
        
        String version = "1";
        System.out.println(version.split("\\.").length);
        
        int i = 0b10000000;
        byte b = (byte)i;
        System.out.println((int)b);
        
//        String[] s = new String[] { "123" };
//        String clName = s.getClass().getName();
//        Test.class.getClassLoader().loadClass(clName);
        
//        try {
//            throw new A("Haha");
//        } catch (Exception e) {
//            try {
//                throw new B(e);
//            } catch (Exception bE) {
//                bE.printStackTrace();
//            }
//        }
        
        System.out.println((2)%(-3)); 
        
        int[] test = new int[Integer.MAX_VALUE];
//        System.out.println(test.length);
    }
    

}


class Solution2 {
    private final static Solution2 instance = new Solution2();
    
    /**
     * @return: The same instance of this class every time
     */
    public static Solution2 getInstance() {
        return instance;
    }
}

class A extends Exception {
    A(String message) {
        super(message);
    }
}

class B extends Exception {
    B(Throwable cause) {
        super(cause);
    }
}

class Base {
    protected void foo(){}
}

class Child extends Base {
    public void foo(){III.foo();}
}

interface III {
    public static void foo() {}
}