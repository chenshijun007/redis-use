package com.example.redis.service;

import com.example.redis.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

/**
 * Created by csj on 2017/12/5.
 */
@Service
@Transactional
public class RedisService {

    @Autowired
    RedisTemplate redisTemplate;



   // @Cacheable(value = "#key", keyGenerator = "andCache")
    public void saveString(String key, String vaule){
        redisTemplate.opsForValue().set(key,vaule,100, TimeUnit.SECONDS);
    }

    public String findString(String key){
        return (String) redisTemplate.opsForValue().get(key);
    }

    public void saveObject(String key){

        if (redisTemplate.hasKey(key)){
            System.out.println("已存在");
        }else {
            User user=new User();
            user.setId("1");
            user.setUsername("张三");
            user.setPassword("123456");

            Map map=new HashMap();
            map.put("1","123");
            map.put("2","234");
            redisTemplate.opsForValue().set(key,user);
        }



    }

    public void  saveList(String key){
        List<User> list=new ArrayList<>();
        User user=new User();
        user.setId("1");
        user.setUsername("张三");
        user.setPassword("123456");
        User user1=new User();
        user1.setId("2");
        user1.setUsername("李四");
        user1.setPassword("234567");
        list.add(user);
        list.add(user1);
        redisTemplate.opsForValue().set(key,list);

    }

    public User getUser(String key){
        User user= (User) redisTemplate.opsForValue().get(key);
        return  user;
    }

    public List<User> getList(String key){
     // List<User> user= (List<User>) redisTemplate.opsForList().range(key,0,-1);//0,-1查询全部
      List<User> user= (List<User>) redisTemplate.opsForValue().get(key);//0,-1查询全部
      return  user;
    }

    public void hashMap(){
        Map map=new HashMap();
        map.put("1","123");
        map.put("2","234");
        redisTemplate.opsForHash().putAll("map:user",map);
    }

    public Map  getMap(){
      //  return  (HashMap) redisTemplate.opsForHash().entries("map:user");
          return (Map) redisTemplate.opsForValue().get("map:map");

    }


}
