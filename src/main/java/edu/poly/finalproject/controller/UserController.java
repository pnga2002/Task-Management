package edu.poly.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.finalproject.entity.UserEntity;
import edu.poly.finalproject.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("")
	public String user(Model model) {
		List<UserEntity> list = userService.findAll();
		model.addAttribute("user",list);
		return "user-table";
	}
	@GetMapping("user-add")
	public String userAdd() {
		return "user-add";
	}
	@GetMapping("user-detail")
	public String userDetail() {
		return "user-details";
	}
	@GetMapping("user-edit")
	public String userEdit() {
		return "user-add";
	}
}
