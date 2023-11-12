package edu.poly.finalproject.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.poly.finalproject.entity.ProjectEntity;
import edu.poly.finalproject.entity.TaskEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity,Integer>{
	
	@Query("Select o From duan o Where o.users.id = ?1")
	Page<ProjectEntity> getProjectByUserId(Integer id,Pageable pageable);
	
	
	
}
