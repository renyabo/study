import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    @org.junit.Test
    public void test() {
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        List<Integer> collect = list.stream().filter(i -> i < 0).collect(Collectors.toList());
        System.out.println(collect.size());
    }


    static class A {
        String a;
        Long b;
        Integer c;
        List<Integer> list;
        String f;

        public String getF() {
            return f;
        }

        public void setF(String f) {
            this.f = f;
        }

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public Long getB() {
            return b;
        }

        public void setB(Long b) {
            this.b = b;
        }

        public Integer getC() {
            return c;
        }

        public void setC(Integer c) {
            this.c = c;
        }

        public List<Integer> getList() {
            return list;
        }

        public void setList(List<Integer> list) {
            this.list = list;
        }
    }

    static class B {
        String a;
        Long b;
        Integer c;
        Short d;
        List<Integer> list;

        public List<Integer> getList() {
            return list;
        }

        public void setList(List<Integer> list) {
            this.list = list;
        }

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public Long getB() {
            return b;
        }

        public void setB(Long b) {
            this.b = b;
        }

        public Integer getC() {
            return c;
        }

        public void setC(Integer c) {
            this.c = c;
        }

        public Short getD() {
            return d;
        }

        public void setD(Short d) {
            this.d = d;
        }
    }

    @org.junit.Test
    public void testCopy() {
        A a = new A();
        a.a = "a";
        a.b = 1L;
        a.c = 3;
        a.list = new ArrayList<>();
        a.list.add(1);
        a.list.add(2);
        a.list.add(3);

        B b = new B();
        BeanUtils.copyProperties(a, b);
        System.out.println(b.list);
    }
}
