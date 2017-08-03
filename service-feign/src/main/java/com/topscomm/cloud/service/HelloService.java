package com.topscomm.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 文件描述：
 * 创建作者：陈苗
 * 创建时间：2017/8/3 9:45
 */
@FeignClient(value = "service-hello", fallback = HelloServiceHystric.class)
public interface HelloService {

    @GetMapping("/hello")
    String sayHelloFromClientOne(@RequestParam("name") String name);
}
