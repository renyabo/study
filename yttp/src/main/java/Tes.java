import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

public class Tes {
    public static void main(String[] args) {
//        HystrixCommand hystrixCommand;
//        int[] a = new int[]{};
//        for (int i : a) {
//            System.out.println(a);
//        }
//        System.out.println("over");
//        ThreadLocal<Long> threadLocal = new ThreadLocal<>();
//        A a = new A();
//        try {
//            a.f1();
//        }catch (Exception e){
//            System.out.println(e instanceof IllegalArgumentException);
//            System.out.println(e.getClass());
//        }

        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }
}

class A {
    void f1() {
        Double d = body(() -> {
            System.out.println("in..");
            Assert.isTrue(false, "hahaha");
            return 1d;
        },"tag");
        System.out.println(d);
    }

    <T> T body(Supplier<T> supplier,String tag) {
        try {
            return supplier.get();
        } catch (Exception e) {
            System.out.println("error....");
            throw e;
        }
    }
}
