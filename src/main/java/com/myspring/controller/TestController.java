package com.myspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspring.service.IUserService;

@RestController
public class TestController {

	@Autowired
	private IUserService userService;

	@RequestMapping("/hello")
	public String index() {
		return "Hello Docker aaa!";
	}

	@RequestMapping("/users")
	public Object showUsers(String name) {
		return userService.findByName(name);
	}
}