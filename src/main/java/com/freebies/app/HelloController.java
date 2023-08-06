package com.freebies.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class HelloController {
	
	@Autowired
	Service2FeignClient service2FeignClient;

	
	@GetMapping("/service-1")
	public String hellloRest( ) {
		
		return "Hello World";
	}
	
	@GetMapping("/invoke")
	@CircuitBreaker(name="service2invoke" , fallbackMethod = "fallback")
	public String invokeFeignClient() {
		
		return service2FeignClient.getService2Invoke();
	}
	
	
	public String fallback( Exception e) {
		
		return "Hello fallback";
	}
	
}
