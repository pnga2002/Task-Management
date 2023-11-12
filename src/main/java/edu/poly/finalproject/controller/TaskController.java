package edu.poly.finalproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.finalproject.entity.TaskEntity;
import edu.poly.finalproject.service.TaskService;

@Controller
public class TaskController {
	@Autowired
	TaskService taskService;

	private Integer maND = 4;
	
	@GetMapping("task")
	public String task(Model model,@RequestParam("p") Optional<Integer> p) {
		Pageable pageable=PageRequest.of(p.orElse(0), 50);
		Page<TaskEntity> list = taskService.getTaskByUserId(maND,pageable);
		for (TaskEntity taskEntity : list) {
			System.out.println(taskEntity.getIdcv());
		}
		model.addAttribute("task",list);
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
