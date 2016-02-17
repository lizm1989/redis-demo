package com.demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Set;

/**
 * Created by zhimingli on 2016/2/17 0017.
 */
public class RedisManager {
    private static final String KEY_REDIS_HOST = "redis.host";
    private static final String KEY_REDIS_MAXACTIVE = "redis.maxactvie";
    private static final String KEY_REDIS_MAXWAIT = "redis.maxwait";
    private static final String KEY_REDIS_MAXIDEL = "redis.idel";


    public static final String RANGE_ORDERBY_DESC = "desc";

    public static final String RANGE_ORDERBY_ASC = "asc";

    protected JedisPool pool;

    public RedisManager() {
        init();
    }

    private void init() {
        String host = "172.16.75.67:6380";
        int maxActive = 300;
        int maxWait = 20;
        int maxIdel = 100;

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxActive(maxActive);
        config.setMaxIdle(maxIdel);
        config.setMaxWait(maxWait);

        String[] hosts = host.split(":");
        pool = new JedisPool(config, hosts[0], Integer.parseInt(hosts[1]));
    }

    private static void releaseJedis(JedisPool pool, Jedis redis) {
        if (redis != null && pool != null) {
            pool.returnResource(redis);
        }
    }


    /**
     * 查询key是否存在
     */
    public boolean keyExists(String key) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            return redis.exists(key);
        } finally {
            releaseJedis(pool, redis);
        }
    }

    //设置某个值
    public void set(String key, String value) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            redis.set(key, value);
        } finally {
            releaseJedis(pool, redis);
        }
    }

    //设置值，并有过期时间
    public void setSec(String key, String value, int timeOutSec) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            redis.set(key, value);
            if (timeOutSec > 0) {
                redis.expire(key, timeOutSec);
            }
        } finally {
            releaseJedis(pool, redis);
        }
    }

    //获取某个key的过期时间
    public Long ttl(String key) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            return redis.ttl(key);
        } finally {
            releaseJedis(pool, redis);
        }
    }

    //移除某个key的过期时间
    public Long persist(String key) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            return redis.persist(key);
        } finally {
            releaseJedis(pool, redis);
        }
    }


    //获取某个key的值
    public String get(String key) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            return redis.get(key);
        } finally {
            releaseJedis(pool, redis);
        }
    }

    //获取所有的key,正则
    public Set<String> getAllKey(String pattern) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            return redis.keys(pattern);
        } finally {
            releaseJedis(pool, redis);
        }
    }


    //移除某个key
    public Long remove(String key) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            return redis.del(key);
        } finally {
            releaseJedis(pool, redis);
        }
    }

    //查看key的类型
    public String type(String key) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            return redis.type(key);
        } finally {
            releaseJedis(pool, redis);
        }
    }

    //在某个key后面追加内容
    public Long append(String key, String value) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            return redis.append(key, value);
        } finally {
            releaseJedis(pool, redis);
        }
    }

    //查看list的长度
    public Long length(String key) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            return redis.llen(key);
        } finally {
            releaseJedis(pool, redis);
        }
    }

    //一次性新增key及其对应值
    public String mset(String... keysvalues) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            return redis.mset(keysvalues);
        } finally {
            releaseJedis(pool, redis);
        }
    }

    //一次性获取key对应值
    public List<String> mget(String... keysvalues) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            return redis.mget(keysvalues);
        } finally {
            releaseJedis(pool, redis);
        }
    }

    //一次性删除key对应值
    public Long mmove(String... keysvalues) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            return redis.del(keysvalues);
        } finally {
            releaseJedis(pool, redis);
        }
    }

    //放入list的值,将所有指定的值插入到存于 key 的列表的头部
    public void lpush(String key, String... strings) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            redis.lpush(key, strings);
        } finally {
            releaseJedis(pool, redis);
        }
    }


    //获取list元素，开始结束
    public List<String> lrange(String key, int start, int end) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            return redis.lrange(key, start, end);
        } finally {
            releaseJedis(pool, redis);
        }
    }


    //从存于 key 的列表里移除前 count 次出现的值为 value 的元素
    //count > 0: 从头往尾移除值为 value 的元素。
    //count < 0: 从尾往头移除值为 value 的元素。
    // count = 0: 移除所有值为 value 的元素。
    //返回成功删除的个数
    public Long lrem(String key, int count, String value) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            return redis.lrem(key, count, value);
        } finally {
            releaseJedis(pool, redis);
        }
    }

    //删除下标start-end区间之外的元素
    //从0开始
    public String ltrim(String key, int start, int end) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            return redis.ltrim(key, start, end);
        } finally {
            releaseJedis(pool, redis);
        }
    }

    //修改指定下标的值
    public String lset(String key, int index, String value) {
        Jedis redis = null;
        try {
            redis = pool.getResource();
            return redis.lset(key, index, value);
        } finally {
            releaseJedis(pool, redis);
        }
    }
}
