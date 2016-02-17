#JAVA学习使用redis


####string方法介绍
----------
1.	 Boolean exists(String key)	判断key是否存在，返回true|false
2.	 String  get(String key)		获取某个key的值
3.	 Long    del(String... key)		移除一个或多个key
4.	 void set(String key,String value) 设置key值为value
5.	 void expire(String key,int seconds) 设置key的过期时间seconds,单位秒
6.	 Long ttl(String key)	返回key的过期时间
7.	 Long persist(String key) 移除key的过期时间
8.	 String type(String key) 返回key的存储类型
9.	 Set<String> keys(String pattern) 查找所有匹配给定模式的键
10.	 Long append(String key,String value) 追加value到key，返回追加后的长度
11.	 String mset(String... keysvalues) 设置多个key value，返回ok
12.	 List<String> mget(String... keys) 指定的key对应的values的list

####list方法介绍
----------
* 
