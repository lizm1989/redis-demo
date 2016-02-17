package com.demo;

import org.junit.Test;

/**
 * Created by zhimingli on 2016/2/17 0017.
 */
public class TestListRedis {
    private RedisManager redis;

    public TestListRedis() {
        redis = new RedisManager();
    }

    @Test
    public void testList() {
        redis.lpush("testlist", "string");
        redis.lpush("testlist", "list");
        redis.lpush("testlist", "set");
        redis.lpush("testlist", "hashset");
        redis.lpush("testlist", "arraylist");
        redis.lpush("testlist", "arraylist");
        redis.lpush("testlist", "arraylist");
        redis.lpush("testlist", "arraylist");


        System.out.println("获取testlist的所有元素==>" + redis.lrange("testlist", 0, -1));

        System.out.println("成功删除指定元素个数==>" + redis.lrem("testlist", 1, "arraylist"));

        redis.lpush("ltrim", "1");
        redis.lpush("ltrim", "2");
        redis.lpush("ltrim", "3");
        redis.lpush("ltrim", "4");
        redis.lpush("ltrim", "5");
        System.out.println("删除下标0-3区间之外的元素==>" + redis.ltrim("ltrim", 0, 3));
        System.out.println("删除下标0-3区间之外的元素ltrim之后的元素==>" + redis.lrange("ltrim", 0, -1));

        System.out.println("数组长度==>" + redis.length("ltrim"));


        System.out.println("修改指定下标的值==》" + redis.lset("ltrim", 0, "1111111111111"));
        System.out.println("获取指定下标的值==》" + redis.lindex("ltrim", 0));
    }
}
