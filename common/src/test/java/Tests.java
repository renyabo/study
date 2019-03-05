import org.junit.Test;
import org.yabo.common.util.TaskManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class Tests {
    @Test
    public void test() throws Exception {
        TaskManager manager = new TaskManager();
//        Map<Integer, Integer> map = new HashMap<>();
//        int size=10000;
//        CountDownLatch latch=new CountDownLatch(size);
//        for (int i = 0; i < size; i++) {
//            final Integer integer = i;
//            manager.getExecutor().execute(() -> {
//                map.put(integer, integer);
//                latch.countDown();
//            });
//        }
//        latch.await();
//        System.out.println("over,size=" + map.values().size());
//        Object o=new Object();
//        manager.getExecutor().execute(() -> {
//            synchronized (o){
//                while (true){
//                    System.out.println("obtain.."+Thread.currentThread());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        while (true) {
//            System.out.println("in");
//            Thread.sleep(10000);
//        }
    }

    class A {
        Integer n = 0;

        @Override
        public String toString() {
            return "A{" +
                    "n=" + n +
                    '}';
        }
    }

    @Test
    public void finallyTest() {
        A a = f();
        System.out.println(a.n);
    }

    private A f() {
        A a = null;
        try {
            a = new A();
            a.n = 3333;
            return a;
        } finally {
            System.out.println(a != null ? a.n : null);
        }
    }

    class Helper {
        Map<Integer, A> map = new HashMap<>();

        public Helper(List<B> list) {
            list.forEach(b -> map.put(b.filter, new A()));
        }

        public A get(Integer key) {
            return map.get(key);
        }
    }

    class B {
        Integer filter;

        public B(Integer filter) {
            this.filter = filter;
        }

        @Override
        public String toString() {
            return "B{" +
                    "filter=" + filter +
                    '}';
        }
    }

    @Test
    public void testForEach() {
        List<B> bs = new ArrayList<>();
        bs.add(new B(1));
        bs.add(new B(2));
        bs.add(new B(4));
        bs.add(new B(4));
        bs.add(new B(6));
        bs.add(new B(4));
        Helper helper = new Helper(bs);
        bs.stream()
                .filter(b -> b.filter > 3)
                .forEach(b -> {
                    A a = helper.get(b.filter);
                    a.n++;
                });
        System.out.println(helper.map);
    }
}
