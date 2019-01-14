import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    @org.junit.Test
    public void test(){
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        List<Integer> collect = list.stream().filter(i -> i < 0).collect(Collectors.toList());
        System.out.println(collect.size());
    }
}
