package com.example.demo.service.cache;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-09 10:29
 */
@CacheConfig(cacheNames = "wenky-test")
@Component
public class SpringCache {

    @Cacheable(key = "#p0")
    public String fetchNullResult(String key) {
        return null;
    }

    // 覆盖cacheNames
    // SimpleKeyGenerator
    @Cacheable(value = "wenky")
    public String fetchNotNullResult(String key) {
        return "huwenqi";
    }

    @Cacheable(key = "#p0.concat(#p1)")
    public String fetchNotNullResult(String key1, String key2) {
        return "wenky";
    }

    // SimpleKeyGenerator
    @Cacheable
    public String fetchNotNullResultWithoutKeyStrategy(String key1, String key2) {
        return "wenky";
    }

    // 需要重写otString方法否则会报错
    // SimpleKeyGenerator
    @Cacheable
    public String fetchNotNullResult(Key key) {
        return "wenky";
    }

    @Cacheable
    public Result fetchResultWithObject(String key) {
        Result result = new Result();
        result.setValue("wenky");
        return result;
    }

    class Key {
        private String key1;
        private String key2;

        public String getKey1() {
            return key1;
        }

        public void setKey1(String key1) {
            this.key1 = key1;
        }

        public String getKey2() {
            return key2;
        }

        public void setKey2(String key2) {
            this.key2 = key2;
        }

        @Override
        public String toString() {
            return "Key{" + "key1='" + key1 + '\'' + ", key2='" + key2 + '\'' + '}';
        }
    }
}
