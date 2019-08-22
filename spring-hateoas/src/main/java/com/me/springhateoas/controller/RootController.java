package com.me.springhateoas.controller;

import com.me.springhateoas.entity.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
public class RootController {

    private static final String MSG = "Hello, %s!";

    @RequestMapping("/greeting")
    public HttpEntity<User> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "User") String name) {

        User user = new User(String.format(MSG, name));
        user.add(linkTo(methodOn(RootController.class).greeting(name)).withSelfRel());

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
