#JAVA学习使用redis


####string方法介绍
----------
1.	 Boolean exists(String key)		判断key是否存在，返回true|false
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
1.	Long lpush(String key, String... strings) 将所有指定的值插入到存于 key 的列表的头部,返回list长度
2.	List<String> lrange(String key,int start,int end)返回存储在key中指定范围内的元素,0开始
3.	Long lrem(String key,int count,String value) 删除key列表里前count个值为value的元素，返回移除个数. count>0从头到尾移除 count<0从尾到头移除，count为0全删
4.	String ltrim(String key,int start,int end) 返回指定范围内元素，返回OK
5.	Long llen(String key) key对应的list长度
6.	String lset(String key,long index,String value) 修改指定下标的值，返回OK
7.	String lindex(String key,long index) 获取指定下标的值

####set方法介绍
----------
1.	Long sadd(String key,String...value) 添加一个或多个元素到集合，返回成功个数
2.	Set<String> smembers(String key) 返回集合所有元素
3.	Long srem(String key,String... value)删除集合指定元素，返回成功个数
4.	String spop(String key) 随机返回集合一个元素
5.	Boolean sismember(String key, String member)查看某个元素是否在集合中
6.	Set<String> sinter(String... key) 交集
7.	Set<String> sunion(String... key) 并集
8.	Set<String> sdiff(String... key) 差集


####sortedset方法介绍
----------	
1.	Long zadd(String key,double var2,String value)添加集合元素
2.	Set<String> zrange(String key,int start,int end)返回集合元素
3.	Long zcard(String key)返回集合元素个数
4.	Long zcount(String key,double var1,double var2)返回集合权重范围个数
5.	Double zscore(String key,String member)返回集合元素的权重


####hash方法介绍
----------	