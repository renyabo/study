package org.yabo.utils.poi;

import sun.net.www.http.HttpClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FGC {
//    public static void main(String[] args) throws InterruptedException {
//        List<CloudKnowledgeExcelParser> parsers = new ArrayList<>();
//        while (true) {
//            parsers.add(new CloudKnowledgeExcelParser());
//            System.out.println(parsers.size());
//        }
//    }

    public static void main(String[] args) {
//        System.out.println(getSum(30));
        String format = String.format("b=%b", false);
        System.out.println(format);
        HttpClient client;
    }

    public static int getSum(int n){
        if (n == 0) return 1;
        int sum = 0;
        for (int i = 0;i<n;i++){
            sum +=getSum(i)*getSum(n-1-i);
        }
        return sum;

    }
}
