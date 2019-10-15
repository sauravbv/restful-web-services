package com.in23minutes.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
public class HelloWorldController {
		
	//@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	@GetMapping(path="/hello-world")
	public String helloworld() {
		return "hello world";
	}
	
	@GetMapping(path= "/hello-world-bean")
	public HelloWorldBean helloworldbean() {
		//throw new RuntimeException("some error happened");
		return new HelloWorldBean("hello World Bean");
	}
	
	@GetMapping(path= "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloworldbean(@PathVariable String name ) {
		return new HelloWorldBean(String.format("Hello world and hello %s", name));
	}
	
}
