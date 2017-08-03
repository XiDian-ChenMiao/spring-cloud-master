package com.topscomm.cloud.controller;

import com.topscomm.cloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件描述：
 * 创建作者：陈苗
 * 创建时间：2017/8/3 9:50
 */
@RestController
public class HelloController {

    @Autowired
    public HelloService service;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return service.helloService(name);
    }
}
