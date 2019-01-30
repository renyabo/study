import org.junit.Test;
import org.yabo.common.util.TaskManager;

import java.util.HashMap;
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
}
