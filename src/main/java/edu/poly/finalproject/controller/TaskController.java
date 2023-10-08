package edu.poly.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("task")
public class TaskController {
	@GetMapping("")
	public String task() {
		return "task";
	}
	@GetMapping("task-edit")
	public String taskEdit() {
		return "task-add";
	}
	@GetMapping("task-add")
	public String taskAdd() {
		return "task-add";
	}
}
