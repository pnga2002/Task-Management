package edu.poly.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {
	@GetMapping("")
	public String role() {
		return "role-table";
	}
	@GetMapping("role-add")
	public String roleAdd() {
		return "role-add";
	}
	@GetMapping("role-edit")
	public String roleEdit() {
		return "role-add";
	}
}
