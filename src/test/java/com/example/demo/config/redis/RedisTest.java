package com.example.demo.config.redis;

import static org.junit.Assert.*;

import com.example.demo.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

public class RedisTest extends BaseTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void test() {
        redisTemplate.opsForValue().set("name", "wenky");
    }
}
