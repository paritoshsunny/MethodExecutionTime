package com.methodExecution.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.methodExecution.Test;
import com.methodExecution.advice.MethodExecutionTimeLogger;

@RestController
@RequestMapping("/api")
public class TestController {

	@GetMapping("/get1")
	@MethodExecutionTimeLogger
	public String get1() throws Exception {
		Test test=new Test();
		test.run();
		return "success";
	}
	
	@GetMapping("/get2")
	@MethodExecutionTimeLogger
	public String get2() throws Exception {
		wait(199);
		return "success";
	}
}
