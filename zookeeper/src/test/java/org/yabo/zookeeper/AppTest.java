package org.yabo.zookeeper;

import static org.junit.Assert.assertTrue;

import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.collections4.ListUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void createZnode(){
        ZkClient client = new ZkClient("172.16.61.128:2181");
        System.out.println(client.exists("/renyabo"));
//        client.writeData("/renyabo",1111);
//        client.create("/renyabo/1","1", CreateMode.EPHEMERAL);
//        client.createEphemeral("/renyabo/1");
//        client.createEphemeral("/renyabo/acl","123");
    }

    @Test
    public void watcher(){
        ZkClient client = new ZkClient("172.16.61.128:2181");
        Map.Entry<List<ACL>, Stat> acl = client.getAcl("/renyabo");
        acl.getKey().forEach(System.out::println);
        System.out.println("----------------");
        System.out.println(acl.getValue());

    }

    @Test
    public void read(){
        ZkClient client = new ZkClient("172.16.61.128:2181");
        String string = client.readData("/renyabo/1");
        System.out.println(string);
    }
}
