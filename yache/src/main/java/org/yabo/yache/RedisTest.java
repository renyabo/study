package org.yabo.yache;

import org.springframework.util.CollectionUtils;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

public class RedisTest {
    public static void main(String[] args) {
//        Jedis jedis = new Jedis("192.168.115.129", 6379);
        HostAndPort n1 = new HostAndPort("192.168.165.16", 6379);
        HostAndPort n2 = new HostAndPort("192.168.165.17", 6379);
        HostAndPort n3 = new HostAndPort("192.168.165.18", 6379);
        Set<HostAndPort> set = new HashSet<>();
        set.add(n1);
        set.add(n2);
        set.add(n3);
        set.forEach(n->{
            Jedis jedis = new Jedis(n.getHost(),n.getPort());
            System.out.println(jedis);
            System.out.println(jedis.get("tnp_sms_ORDER_CONFIRM_SMS_201905270069135"));
        });
//        JedisCluster jedisCluster = new JedisCluster(set);
//        System.out.println(jedisCluster);
//        String value = jedisCluster.get("tnp_sms_ORDER_CONFIRM_SMS_201905270069135");
//        System.out.println(value);
//        String test = jedis.set("test", "1");
//        Set<String> keys = jedis.keys("*");
//        System.out.println(keys);
//        if (keys != null && !keys.isEmpty()) {
//            keys.forEach(key -> System.out.println("[" + key + "=" + jedis.get(key)+"]"));
//        }
    }
}
