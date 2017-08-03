package com.topscomm.cloud.service;

import org.springframework.stereotype.Component;

/**
 * 文件描述：
 * 创建作者：陈苗
 * 创建时间：2017/8/3 10:22
 */
@Component
public class HelloServiceHystric implements HelloService {
    @Override
    public String sayHelloFromClientOne(String name) {
        return "Sorry " + name;
    }
}
