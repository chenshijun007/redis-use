package com.example.redis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by csj on 2017/12/5.
 */
public class User {
    private String id;
    private String username;
    @JsonIgnore
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
