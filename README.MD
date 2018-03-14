redis是一个key-value存储系统。
它支持存储的value类型相对更多，包括string(字符串)、list(链表)、set(集合)、
zset(sorted set --有序集合)和hash（哈希类型）。
redis会周期性的把更新的数据写入磁盘或者把修改操作写入追加的记录文件，
并且在此基础上实现了master-slave(主从)同步


（key）文件命名：应用名称：模块名称：唯一标识
（value） 值：字符串，对象，

redisTemplate.opsForValue();//操作字符串
redisTemplate.opsForHash();//操作hash
redisTemplate.opsForList();//操作list
redisTemplate.opsForSet();//操作set
redisTemplate.opsForZSet();//操作有序set


Jackson2JsonRedisSerializer，
JacksonJsonRedisSerializer，
JdkSerializationRedisSerializer, //序列化成16进制
GenericToStringSerializer，  
StringRedisSerializer，
GenericJackson2JsonRedisSerializer, //可读性好，直观
OxmSerializer。

