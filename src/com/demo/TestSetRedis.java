package com.demo;

import org.junit.Test;

/**
 * Created by zhimingli on 2016/2/17 0017.
 */
public class TestSetRedis {
    private RedisManager redis;

    public TestSetRedis() {
        redis = new RedisManager();
    }

    @Test
    public void testSet() {
        redis.sadd("testSet", "111");
        redis.sadd("testSet", "222");
        redis.sadd("testSet", "333");
        redis.sadd("testSet", "444");
        redis.sadd("testSet", "555");

        System.out.println("查看testSet集合所有元素==>" + redis.smembers("testSet"));
        System.out.println("删除指定集合元素，返回成功个数==>" + redis.srem("testSet", new String[]{"555", "444", "666"}));
        System.out.println("查看testSet集合所有元素==>" + redis.smembers("testSet"));

        System.out.println("随机返回一个元素==>" + redis.spop("testSet"));
        System.out.println("查看testSet集合所有元素==>" + redis.smembers("testSet"));

        System.out.println("查看某个元素是否在集合中==>" + redis.sismember("testSet", "111"));
    }
}
