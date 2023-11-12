package edu.poly.finalproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.poly.finalproject.entity.ProjectEntity;
import edu.poly.finalproject.entity.TaskEntity;
import edu.poly.finalproject.repository.ProjectRepository;

@Service
public class ProjectService {
	private final ProjectRepository projectRepository;

	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public Page<ProjectEntity> getProjectByUserId(Integer id, Pageable pageable) {

		return projectRepository.getProjectByUserId(id, pageable);
	}

	public Optional<ProjectEntity> findById(Integer id) {

		return projectRepository.findById(id);
	}
	

}
