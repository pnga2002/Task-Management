package edu.poly.finalproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import edu.poly.finalproject.provider.CustomAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	//403 forbidden: thang nay kh co quyen truy cap vao  hoi giong 401
	//java 11 vaf java 8 thi la antMatcher
	//java 17 thif se la
	
	@Autowired
    CustomAuthenticationProvider customAuthenManagerProvider;

	
	//Khai baso chuaarn ma hoa password va dua len IOC
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	//tao thu tai khoan va luu tai khoan len RAM
//	@Bean
//	public UserDetailsService userDetailService(PasswordEncoder passwordEncoder) {
//		UserDetails admin = User.withUsername("cybersoft")
//				.password(passwordEncoder.encode("123123"))
//				.roles("ADMIN")
//				.build();
//		UserDetails user = User.withUsername("nguyenvana")
//				.password(passwordEncoder.encode("123"))
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(admin,user);
//	}
//	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
				.authenticationProvider(customAuthenManagerProvider)
				.build();
	}
	
	//quy dinh cau hinh cho security
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecuriry) throws Exception{
		return httpSecuriry.csrf().disable()//disable tan cong  dang cross-site vi dang su dung API
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeHttpRequests()
					.antMatchers("/user/**").permitAll()//không cần đăng nhập vẫn truy cập được
					.antMatchers(HttpMethod.POST,"/product").hasRole("ADMIN")
					.antMatchers(HttpMethod.GET,"/product").hasAnyRole("ADMIN","USER")
					.anyRequest().authenticated()//tất cả các request còn lại đều phải chức thực
				.and().httpBasic()//su dung kieu chung thuc basic authen
				.and().build();
	}
}
