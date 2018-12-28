package org.yabo.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.collections4.CollectionUtils;
import org.yabo.common.Define;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(Define.USER);
        ZkClient client = new ZkClient("172.16.61.128:2181");
        List<String> children = client.getChildren("/");
        if (CollectionUtils.isNotEmpty(children)) {
            children.forEach(System.out::println);
        }
    }
}
