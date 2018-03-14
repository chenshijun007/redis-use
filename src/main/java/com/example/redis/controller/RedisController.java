package com.example.redis.controller;

import com.example.redis.domain.User;
import com.example.redis.service.RedisService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by csj on 2017/12/5.
 */

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    RedisService redisService;


    @RequestMapping(value = "/save/string",method = RequestMethod.POST)
    public void saveString(String key,String value){
     redisService.saveString(key,value);
    }


    @RequestMapping(value = "/save/object",method = RequestMethod.POST)
    public void saveObject(String key){
        redisService.saveObject(key);
    }


    @RequestMapping(value = "/save/list",method = RequestMethod.POST)
    public void saveList(String key){
        redisService.saveList(key);
    }

    @RequestMapping(value = "/save/map",method = RequestMethod.GET)
    public void saveMap(){
        redisService.hashMap();
    }


    @RequestMapping(value = "/find/object",method = RequestMethod.GET)
    public User findObject(String key){
       return   redisService.getUser(key);
    }
    @RequestMapping(value = "/find/string",method = RequestMethod.GET)
    public String findString(String key){
       return   redisService.findString(key);
    }


    @RequestMapping(value = "/find/list",method = RequestMethod.GET)
    public List<User> findList(String key){
        return   redisService.getList(key);
    }



    @RequestMapping(value = "/find/map",method = RequestMethod.GET)
    public Map findMap(){
     return   redisService.getMap();
    }
}
