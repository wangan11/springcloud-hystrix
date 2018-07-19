package com.spring.cloud.server.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangan on 2018/7/19
 * @description
 */
 @SpringBootApplication
 @EnableCircuitBreaker // 使用服务短路
public class ServerClientApplication {


	public static void main(String[] args) {
		SpringApplication.run(ServerClientApplication.class,args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}


}
