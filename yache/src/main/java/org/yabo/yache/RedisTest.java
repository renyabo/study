package org.yabo.yache;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisSentinelPool;

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



        Set<String> sen=new HashSet<>();
        sen.add("192.168.165.16:26379");
        sen.add("192.168.165.17:26379");
        sen.add("192.168.165.18:26379");
        GenericObjectPoolConfig gPoolConfig=new GenericObjectPoolConfig();
        gPoolConfig.setMaxIdle(10);
        gPoolConfig.setMaxTotal(10);
        gPoolConfig.setMaxWaitMillis(10);
        gPoolConfig.setJmxEnabled(true);
        JedisSentinelPool jSentinelPool=new JedisSentinelPool("master",sen,gPoolConfig);

        System.out.println(jSentinelPool);


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
