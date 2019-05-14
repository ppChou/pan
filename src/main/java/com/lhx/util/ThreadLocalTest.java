package com.lhx.util;

public class ThreadLocalTest {

    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();


    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest test = new ThreadLocalTest();


        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());


        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                System.out.println("333");
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };
        System.out.println("1111");
        thread1.start();
        System.out.println("222");
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}
