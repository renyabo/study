package org.yabo.spring.test;

import com.mysql.jdbc.jdbc2.optional.MysqlXid;

import javax.transaction.xa.Xid;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
//        TaskManager taskManager = new TaskManager("Yabo");
//        for (int i = 0; i < 100000; i++) {
//            System.out.println(i);
//            taskManager.getExecutor().execute(() -> System.out.println(Thread.currentThread()));
//        }
//        System.out.println("over");
//        String json="[{\"a\":1},{\"b\":2}]";
//        System.out.println(json);
//        Object parse = JSON.parse(json);
//        System.out.println(parse.getClass());

//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
//        Service service = applicationContext.getBean(Service.class);
//        System.out.println(service);
//        System.out.println(((char) 0x011));
//        System.out.println(((char) 0x012));

//        String format = String.format("'%c','%c',%d", 0x012, 0x011, 100);
//        System.out.println(format);
        Xid xid1 = new MysqlXid(new byte[] { 0x011 }, new byte[] { 0x012 }, 100);
        byte[] globalTransactionId = xid1.getGlobalTransactionId();
        System.out.println(Arrays.toString(globalTransactionId));
    }
}
