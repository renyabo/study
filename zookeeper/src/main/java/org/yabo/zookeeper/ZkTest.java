package org.yabo.zookeeper;

import org.I0Itec.zkclient.ZkClient;

import java.util.List;

public class ZkTest {
    public static void main(String[] args) {
        ZkClient client = new ZkClient("192.168.115.129:2181");
        dfs(client, "/");
//        System.out.println(client.getChildren("/"));
        System.out.println("over...");
    }

    private static void dfs(ZkClient client, String path) {
        System.out.println(path);
        if (client.exists(path)) {
            List<String> children = client.getChildren(path);
            if (children != null && !children.isEmpty()) {
                children.forEach(child -> dfs(client, path + ("/".equals(path) ? "" : "/") + child));
            }
        }
    }
}
