package edu.poly.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {
	@GetMapping("")
	public String index() {
		return "index";
	}
	@GetMapping("profile")
	public String profile() {
		return "profile";
	}
	@GetMapping("/*")
	public String pageNotFOund() {
		return "404";
	}
}
