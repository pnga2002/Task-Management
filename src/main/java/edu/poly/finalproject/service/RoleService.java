package edu.poly.finalproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.poly.finalproject.entity.ProjectEntity;
import edu.poly.finalproject.entity.RoleEntity;
import edu.poly.finalproject.repository.RoleRepository;


@Service
public class RoleService {
	private final RoleRepository roleRepository;
	
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	public List<RoleEntity> findAll() {
		return roleRepository.findAll();
	} 
}
