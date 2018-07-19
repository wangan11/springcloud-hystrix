package com.spring.cloud.server.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.spring.cloud.server.client.domin.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author wangan on 2018/7/19
 * @description
 */
@RestController
public class ServerClientController {

	@Autowired
	private RestTemplate restTemplate;
	private final Random random=new Random();

	@Value("${server.instance.address}")
	private String serverInstanceAddress;

	@GetMapping("/req/getUser")
	@HystrixCommand(fallbackMethod = "defaultStores",commandProperties ={@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "100")})
	public List<User> getRemoteUser() throws InterruptedException {
		int expireTime = random.nextInt(200);
		System.out.println(expireTime);
		Thread.sleep(expireTime);
		return restTemplate.getForObject(serverInstanceAddress+"/getUser",List.class);
	}
	public List<User> defaultStores(){
		return new ArrayList<>();
	}
}
