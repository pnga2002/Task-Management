package edu.poly.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.finalproject.utils.JwtHelper;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	AuthenticationManager authenManage;
	
	@Autowired
	private JwtHelper jwtHelper;
	
	@PostMapping("/signin")
	public ResponseEntity<?> signin(@RequestParam String username,@RequestParam String pass){
		UsernamePasswordAuthenticationToken authen = new UsernamePasswordAuthenticationToken(username, pass);
		authenManage.authenticate(authen);
		
		String token = jwtHelper.generateToken("Muon cho gi cho");
		return new ResponseEntity<>(token, HttpStatus.OK);
	}
	@PostMapping("/signup")
	public ResponseEntity<?> signup(){
		
		return new ResponseEntity<>("sign up",HttpStatus.OK);
	}
}
