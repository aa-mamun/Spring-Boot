package com.me.springhateoas.entity;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User extends ResourceSupport {

    private final String name;

    @JsonCreator
    public User(@JsonProperty("content") String content) {
        this.name = content;
    }

    public String getContent() {
        return name;
    }
}
