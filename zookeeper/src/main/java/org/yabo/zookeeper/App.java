package org.yabo.zookeeper;

import org.I0Itec.zkclient.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.zookeeper.Watcher;
import org.yabo.common.Define;
import org.yabo.common.Result;

import java.util.List;

/**
 * Hello world!
 * 命令行启动： java -cp ./classes:./lib/* org.yabo.zookeeper.App
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        ZkClient client = new ZkClient("172.16.61.128:2181");
//        client.createPersistent("/renyabo", "data");
        client.subscribeChildChanges("/renyabo", (parentPath, currentChilds) ->
                System.out.println(String.format("child changes,parentPath=%s,currentChilds=%s", parentPath, currentChilds)));
        client.subscribeDataChanges("/renyabo", new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println(String.format("data change,path=%s,data=%s", dataPath, data.toString()));
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println("data delete,path=" + dataPath);
            }
        });
        client.subscribeStateChanges(new IZkStateListener() {
            @Override
            public void handleStateChanged(Watcher.Event.KeeperState state) throws Exception {
                System.out.println("state changed,state=" + state);
            }

            @Override
            public void handleNewSession() throws Exception {
                System.out.println("handleNewSession");
            }

            @Override
            public void handleSessionEstablishmentError(Throwable error) throws Exception {
                System.out.println("error,throws=" + error);
            }
        });
//        client.createEphemeral("/renyabo","ryb");
//        Result<List<String>> result = getResult(client);
//        System.out.println(result.getCode());
//
//        if (CollectionUtils.isNotEmpty(result.getData())) {
//            result.getData().forEach(System.out::println);
//        }
        Thread.sleep(Integer.MAX_VALUE);
    }

    private static Result<List<String>> getResult(ZkClient client) {
//        client.subscribeChildChanges("/")
        List<String> children = client.getChildren("/");
        Result<List<String>> result = new Result<>();
        result.setCode(200);
        result.setMessage("OK");
        result.setData(children);
        return result;
    }
}
