package edu.poly.finalproject.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.poly.finalproject.entity.UserEntity;
import edu.poly.finalproject.repository.UserRepository;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	@Lazy
	private PasswordEncoder passencoder;
	
	@Override
	public Authentication authenticate(Authentication authentication){
		String username = authentication.getName();
		String pass = authentication.getCredentials().toString();
		
		UserEntity user = userRepository.findByEmail(username);
		if(user!=null) {
			//user ton tai trong csdl thi kiem tra tiep password
			if(passencoder.matches(pass, user.getMatkhau())) {
				//thanh cong, tao chung thuc theo chuan security
				List<GrantedAuthority> roles = new ArrayList<>();
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName());
				roles.add(authority);
				UsernamePasswordAuthenticationToken token = 
						new UsernamePasswordAuthenticationToken(username, user.getMatkhau(),roles);
				return token;
			} else {
				return null;
			}
		}else {
			return null;
		}
	}
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
