package com.demo;

import org.junit.Test;

/**
 * Created by zhimingli on 2016/2/17 0017.
 */
public class TestSortedSetRedis {
    private RedisManager redis;

    public TestSortedSetRedis() {
        redis = new RedisManager();
    }

    @Test
    public void testSortedSet() {
        redis.zadd("zset", 7.0, "7777");
        redis.zadd("zset", 8.0, "8888");
        redis.zadd("zset", 9.0, "9999");
        redis.zadd("zset", 5.0, "5555");
        redis.zadd("zset", 6.0, "6666");

        System.out.println("返回所有集合元素》" + redis.zrange("zset", 0, -1));

        System.out.println("删除集合中的元素》" + redis.zrem("zset", "6666"));
        System.out.println("返回所有集合元素》" + redis.zrange("zset", 0, -1));
        System.out.println("返回集合元素个数》" + redis.zcard("zset"));
        System.out.println("返回集合元素个数》" + redis.zcount("zset", 7.0, 9.0));

        System.out.println("返回集合元素的权重》" + redis.zscore("zset", "9999"));
    }
}
