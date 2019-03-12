package com.mamun.springbootexternaltomcatdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @RequestMapping(value = "/")
    public String getRootPage(){

        return "root page";
    }

}
