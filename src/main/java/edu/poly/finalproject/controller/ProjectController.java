package edu.poly.finalproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {
	@GetMapping("")
	public ResponseEntity<?> getProject(){
		return new ResponseEntity<>("Project Get",HttpStatus.OK);
	}
	@PostMapping("")
	public ResponseEntity<?> insertProject(){
		return new ResponseEntity<>("Project INsert",HttpStatus.OK);
	}
}
