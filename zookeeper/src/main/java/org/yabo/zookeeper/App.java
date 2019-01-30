package org.yabo.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.collections4.CollectionUtils;
import org.yabo.common.Define;
import org.yabo.common.Result;

import java.util.List;

/**
 * Hello world!
 * 命令行启动： java -cp ./classes:./lib/* org.yabo.zookeeper.App
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(Define.USER);
        Result<List<String>> result = getResult();
        System.out.println(result.getCode());

        if (CollectionUtils.isNotEmpty(result.getData())) {
            result.getData().forEach(System.out::println);
        }
    }

    private static Result<List<String>> getResult() {
        ZkClient client = new ZkClient("172.16.61.128:2181");
        List<String> children = client.getChildren("/");
        Result<List<String>> result = new Result<>();
        result.setCode(200);
        result.setMessage("OK");
        result.setData(children);
        return result;
    }
}
