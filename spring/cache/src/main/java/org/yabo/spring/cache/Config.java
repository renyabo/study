package org.yabo.spring.cache;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class Config {

    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        map.put("key", list);


        map.values().forEach(l->{
            Map<Boolean, List<Integer>> collect = l.stream().collect(Collectors.groupingBy(n -> n > 10));
            System.out.println(collect.getOrDefault(true,new ArrayList<>()));
            System.out.println(collect.get(false));
        });

//        map.values().forEach(l->{
//            List<Integer> collect = l.stream().filter(n -> n > 10).collect(Collectors.toList());
//            Optional<Integer> min = l.stream().min(Comparator.comparingInt(Integer::intValue));
//            collect.add(min.get());
//            l.clear();
//            l.addAll(collect);
//        });


//
//
//        map.values().forEach(l->{
//            Optional<Integer> min = l.stream().min(Comparator.comparingInt(Integer::intValue));
//            List<Integer> swap=new ArrayList<>();
//            swap.add(min.get());
//            l.forEach(n->{
//                if (n>2){
//                    swap.add(n);
//                }
//            });
//            l.clear();
//            l.addAll(swap);
//        });

        map.forEach((key, value) -> {
            System.out.println(key + "  " + value);
        });

//        map.forEach((key,value)->{
//            Optional<Integer> min = value.stream().min(Comparator.comparingInt(Integer::intValue));
//            value.clear();
//            value.add(min.get());
//        });
//        map.values().forEach(System.out::println);
//
    }
}
