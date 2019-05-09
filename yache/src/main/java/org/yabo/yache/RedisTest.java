package org.yabo.yache;

import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.166.11", 6379);
//        String test = jedis.set("test", "1");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        if (keys != null && !keys.isEmpty()) {
            keys.forEach(key -> System.out.println("[" + key + "=" + jedis.get(key)+"]"));
        }
    }
}
