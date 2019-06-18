package org.yabo.zookeeper;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import javax.annotation.PostConstruct;
import java.util.List;

public class ZkTest {

    @PostConstruct
    public static void f(){

    }

    public static void main(String[] args) {
        ZkClient client = new ZkClient("192.168.115.129:2181");
        client.createEphemeral("/a/b/c");


        client.subscribeDataChanges("/lock", new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                List<String> children = client.getChildren(dataPath);
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {

            }
        });
//        dfs(client, "/");
//        System.out.println(client.getChildren("/"));
//        System.out.println("over...");
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
