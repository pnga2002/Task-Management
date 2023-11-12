package edu.poly.finalproject.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.poly.finalproject.entity.TaskEntity;
import edu.poly.finalproject.repository.TaskRepository;
@Service
public class TaskService {
private final TaskRepository taskRepository;
	
	public TaskService (TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public Page<TaskEntity> getTaskByUserId(Integer id,Pageable pageable){
		
		return taskRepository.gettaskByUserId(id,pageable);
	}
	public List<TaskEntity> getTastByProject(Integer id,Integer idtt){
		return taskRepository.getTastByProject(id,idtt);
	}
}
