package com.freebies.app;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="service-2", url="localhost:8082")
public interface Service2FeignClient {

	@GetMapping("/invokeservice")
	public String getService2Invoke();
}
