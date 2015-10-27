package wangheng.common;

import java.util.IdentityHashMap;
import java.util.Map;

public class HashTest {
    public static void main(String[] args) {
        HashA a = new HashA();
        Map<Object, Boolean> injectedObjects = new IdentityHashMap<>();
        injectedObjects.put(a, true);
        System.out.println(injectedObjects.containsKey(a));
        System.out.println(a.hashCode());
        a.i = 4645656;
        System.out.println(injectedObjects.containsKey(a));
        System.out.println(a.hashCode());
        a.i = 3295484;
        System.out.println(injectedObjects.containsKey(a));
        System.out.println(a.hashCode());
    }
}

class HashA {
    int i;
}