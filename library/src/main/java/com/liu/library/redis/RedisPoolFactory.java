package com.liu.library.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * @作者：柳景兴
 * @时间：2020-3-20
 * @描述：读取RedisConfig的值并创建JedisPool
 * @技术：工厂模式进行解耦
 *        JedisPool生成Jedis
 *        Bean注解将方法交给Spring容器进行管理
 *        Service注解将类注册为外观模型，屏蔽细节
 *        Autowired注解自动装配对象
 */
@Service
public class RedisPoolFactory {
    @Autowired
    private RedisConfig redisConfig;

    @Bean
    public JedisPool jedisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(redisConfig.getMaxIdle());
        jedisPoolConfig.setMaxWaitMillis(redisConfig.getMaxWait());
        jedisPoolConfig.setMaxTotal(redisConfig.getMaxActive());
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, redisConfig.getHost(), redisConfig.getPort(),
                redisConfig.getTimeOut(), redisConfig.getPassword(), 0);
        return jedisPool;
    }
}
