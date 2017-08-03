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
public class ServiceMiyaApplication {
    private static final Logger logger = LoggerFactory.getLogger(ServiceMiyaApplication.class);
    @Autowired
    private RestTemplate restTemplate;
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
	public static void main(String[] args) {
		SpringApplication.run(ServiceMiyaApplication.class, args);
	}

	@GetMapping("/home")
    public String home() {
	    logger.info("call /home");
	    return "This is service-miya home";
    }

    @GetMapping("/miya")
    public String info() {
	    logger.info("call service-miya info");
	    return restTemplate.getForObject("http://localhost:8988/info", String.class);
    }
}
