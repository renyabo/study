import com.netflix.hystrix.HystrixCommand;
import rx.Observable;
import rx.Subscriber;

public class Tes {
    public static void main(String[] args) {
        HystrixCommand hystrixCommand;
        int[] a=new int[]{};
        for(int i:a){
            System.out.println(a);
        }
        System.out.println("over");
        ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    }
}
