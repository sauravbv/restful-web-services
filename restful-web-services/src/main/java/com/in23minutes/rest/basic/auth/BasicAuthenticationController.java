	package com.in23minutes.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthenticationController {

	
 
	@GetMapping(path = "/basicauth")
	public AuthenticationBean helloworldbean() {
		// throw new RuntimeException("some error happened");
		return new AuthenticationBean("you are authenticated");
	}



}
