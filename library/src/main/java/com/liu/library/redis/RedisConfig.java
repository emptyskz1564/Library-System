package com.liu.library.redis;


import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PropertySource("classpath:application.yml")
@Component
public class RedisConfig {
    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getPassword() {
        return password;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public int getMaxActive() {
        return maxActive;
    }

    @org.springframework.beans.factory.annotation.Value("${spring.redis.host}")
    private String host;
    @org.springframework.beans.factory.annotation.Value("${spring.redis.port}")
    private int port;
    @org.springframework.beans.factory.annotation.Value("${spring.redis.password}")
    private String password;
    @org.springframework.beans.factory.annotation.Value("${spring.redis.timeout}")
    private int timeOut;
    @org.springframework.beans.factory.annotation.Value("${spring.redis.lettuce.pool.max-idle}")
    private int maxIdle;
    @org.springframework.beans.factory.annotation.Value("${spring.redis.lettuce.pool.max-wait}")
    private int maxWait;
    @Value("${spring.redis.lettuce.pool.max-active}")
    private int maxActive;
}
