package com.revature.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="User-Service")
public interface AuthInterface {
	@PostMapping("/users/authorize")
	public boolean authorize(@RequestHeader(name = "auth") String token);
}
