package edu.poly.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.finalproject.entity.RoleEntity;
import edu.poly.finalproject.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	RoleService roleService;
	@GetMapping("")
	public String role(Model model) {
		List<RoleEntity> list = roleService.findAll();
		model.addAttribute("role",list);
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
