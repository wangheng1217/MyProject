package wangheng.concurrent;

class Add extends Thread {
    int value;

    public void run() {
        value = 1 + 2;
    }
}

class Mul extends Thread {
    int value;

    public void run() {
        value = 1 * 2;
    }
}

public class Main {
    public static void main(String[] args) {
        Add t1 = new Add();
        Mul t2 = new Mul();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double n = ((double) t1.value / t2.value);

        System.out.println(n);
    }
}