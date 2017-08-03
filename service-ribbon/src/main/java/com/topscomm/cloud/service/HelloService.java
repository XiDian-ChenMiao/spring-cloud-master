package com.topscomm.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 文件描述：
 * 创建作者：陈苗
 * 创建时间：2017/8/3 9:45
 */
@Service
public class HelloService {
    @Autowired
    public RestTemplate restTemplate;

    /**
     * 提供断路连接回调判断
     */
    @HystrixCommand(fallbackMethod = "helloError")
    public String helloService(String name) {
        return restTemplate.getForObject("http://service-hello/hello?name=" + name, String.class);
    }

    public String helloError(String name) {
        return "Hello " + name + ", something wrong!";
    }
}
