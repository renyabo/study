package org.yabo.zookeeper;

import org.I0Itec.zkclient.ZkClient;

import java.util.List;

public class ZkTest {
    public static void main(String[] args) {
        ZkClient client = new ZkClient("192.168.165.16:2181,192.168.165.17:2182,192.168.165.18:2183");
        dfs(client, "/");
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
