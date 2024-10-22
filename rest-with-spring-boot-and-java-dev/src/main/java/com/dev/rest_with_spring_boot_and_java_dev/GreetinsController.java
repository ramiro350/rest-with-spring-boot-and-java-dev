package com.dev.rest_with_spring_boot_and_java_dev;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetinsController {
  private static final String template = "Hello, %s!";
  private static AtomicLong counter = new AtomicLong();
  
  @RequestMapping("/greetins")
	public Greetins greetins(
			@RequestParam(value = "name", defaultValue = "World") 
			String name) {
		return new Greetins(counter.incrementAndGet(), String.format(template, name));
	}
}
