package org.yabo.yache;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource("classpath:redis.properties")
@EnableCaching
public class CacheConfiguration {

    @Bean(name = "jedisConnectionFactory")
    public JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory(new RedisStandaloneConfiguration());
    }

    @Bean
    public CacheManager cacheManager(@Qualifier("jedisConnectionFactory") JedisConnectionFactory jedisConnectionFactory) {
        return new RedisCacheManager(RedisCacheWriter.nonLockingRedisCacheWriter(jedisConnectionFactory), RedisCacheConfiguration.defaultCacheConfig());
    }
}
