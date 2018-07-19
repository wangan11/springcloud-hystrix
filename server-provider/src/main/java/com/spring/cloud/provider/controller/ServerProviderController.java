package com.spring.cloud.provider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.spring.cloud.provider.domin.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author wangan on 2018/7/19
 * @description
 */
 @RestController
public class ServerProviderController {
	private List<User> userList=new ArrayList<>();
	private final static Random random = new Random();


	@GetMapping("/getUser")
	@HystrixCommand(fallbackMethod = "defaultStores",commandProperties ={@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "100")})
	public List<User> getUserMap() throws InterruptedException {
		int expireTime = random.nextInt(200);
		System.out.println("expire time:"+expireTime);
		Thread.sleep(expireTime);
		return  userList;
	}

	@PostMapping("/saveUser")
	public void saveUser(@RequestBody User user){
		userList.add(user);
	}

	public List<User> defaultStores(){
		return new ArrayList<>();
	}
}
