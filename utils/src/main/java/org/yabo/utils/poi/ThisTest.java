package org.yabo.utils.poi;

public abstract class ThisTest {
    abstract void test();

    void f() {
        test();
    }

    void f1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ThisTest.this.test();
            }
        }).start();
    }

    void f2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                test();
            }
        }).start();
    }
}
