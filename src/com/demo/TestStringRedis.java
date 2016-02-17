package com.demo;

import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by zhimingli on 2016/2/17 0017.
 */
public class TestStringRedis {
    private RedisManager redis;

    public TestStringRedis() {
        redis = new RedisManager();
    }

    @Test
    public void testStringCommon() {
        System.out.println("判断test-key1是否存在>" + redis.keyExists("test-key1"));
        redis.set("test-key1", "value1111");
        System.out.println("判断test-key1是否存在>" + redis.keyExists("test-key1"));

        System.out.println("获取test-key1的值===>" + redis.get("test-key1"));
        System.out.println("移除test-key1的值===>" + redis.remove("test-key1"));
        System.out.println("获取test-key1的值===>" + redis.get("test-key1"));


        //设置过期时间
        redis.setSec("test-key-time", "value-time", 50);

        System.out.println("获取test-key1的过期时间===>" + redis.ttl("test-key-time"));
        System.out.println("移除test-key1的过期时间===>" + redis.persist("test-key-time"));
        System.out.println("获取test-key1的过期时间===>" + redis.ttl("test-key-time"));

        redis.setSec("test-key-time", "value-time", 50);

        System.out.println("查看test-key-time所储存的值的类型===>" + redis.type("test-key-time"));

        System.out.println("===========获取所有的开始=====================");
        Set<String> allKey = redis.getAllKey("*");//这里可以传正则
        for (String str : allKey) {
            System.out.println(str);
        }
        System.out.println("===========获取所有的结束=====================");
    }

    @Test
    public void testString() {
        redis.set("key001", "value001");
        redis.set("key002", "value002");
        redis.set("key003", "value003");

        System.out.println("key001==>" + redis.get("key001"));
        System.out.println("在key001后面追加内容:" + redis.append("key001", "appendvalue"));
        System.out.println("key001==>" + redis.get("key001"));

        redis.mset("key201", "value201", "key202", "value202", "key203", "value203");

        List<String> list = redis.mget("key201", "key202", "key203");
        System.out.println("一次性获取key201,key202,key203的值" + list);


    }

}
