package com.topscomm.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ServiceHelloApplication {
    private static final Logger logger = LoggerFactory.getLogger(ServiceHelloApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ServiceHelloApplication.class, args);
	}

	@Autowired
    private RestTemplate restTemplate;

	@Bean
    public RestTemplate getRestTemplate() {
	    return new RestTemplate();
    }

    @GetMapping("/hello")
    public String home() {
	    logger.info("call trace service-hello");
	    return restTemplate.getForObject("http://localhost:8989/miya", String.class);
    }

    @GetMapping("/info")
    public String info() {
	    logger.info("call trace service-hello");
	    return "This is service-hello";
    }

}
