package com.spring.cloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @author wangan on 2018/7/19
 * @description
 */
 @SpringBootApplication
 @EnableCircuitBreaker
public class ServerProviderAppliction {

	public static void main(String[] args) {
		SpringApplication.run(ServerProviderAppliction.class,args);
	}

}
