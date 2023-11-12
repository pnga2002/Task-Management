package edu.poly.finalproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.finalproject.entity.ProjectEntity;
import edu.poly.finalproject.entity.TaskEntity;
import edu.poly.finalproject.service.ProjectService;
import edu.poly.finalproject.service.TaskService;

@Controller
public class ProjectController {
	@Autowired
	ProjectService projectService;
	@Autowired
	TaskService taskService;
	//get id user from login service 
	private Integer maND = 3;
	
	@GetMapping("project")
	public String project(Model model,@RequestParam("p") Optional<Integer> p) {
		Pageable pageable=PageRequest.of(p.orElse(0), 50);
		Page<ProjectEntity> list = projectService.getProjectByUserId(maND,pageable);
		model.addAttribute("project",list);
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
	@GetMapping("project/{id}")
	public String projectDetail(Model model,@PathVariable("id") Integer id) {
		/*
		 * Optional<ProjectEntity> project = projectService.findById(id);
		 * if(project.isPresent()) { ProjectEntity pro = project.get();
		 * model.addAttribute("project",pro); }
		 */
		List<TaskEntity> listNewTask = taskService.getTastByProject(id,1);
		model.addAttribute("listNewTask",listNewTask);
		List<TaskEntity> listDoingTask = taskService.getTastByProject(id,2);
		model.addAttribute("listDoingTask",listDoingTask);
		List<TaskEntity> listDoneTask = taskService.getTastByProject(id,3);
		model.addAttribute("listDoneTask",listDoneTask);
		int countNew = listNewTask.size();
		int countDoing = listDoingTask.size();
		int countDone = listDoneTask.size();
		int total = countDoing + countDone + countNew;
		if(total==0) {
			model.addAttribute("percentNew","0%");
			model.addAttribute("percentDoing","0%");
			model.addAttribute("percentDone","0%");
		} else {
		model.addAttribute("percentNew",(countNew*100/total)+"%");
		model.addAttribute("percentDoing",(countDoing*100/total)+"%");
		model.addAttribute("percentDone",(countDone*100/total)+"%");}
		return "groupwork-details";
	}
}
