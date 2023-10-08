package edu.poly.finalproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@GetMapping("")
	public String project() {
		return "groupwork";
	}
	@GetMapping("project-add")
	public String projectAdd() {
		return "groupwork-add";
	}
	@GetMapping("project-edit")
	public String projectEdit() {
		return "groupwork-add";
	}
	@GetMapping("project-detail")
	public String projectDetail() {
		return "groupwork-details";
	}
}
