package edu.poly.finalproject.utils;


import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtHelper {
	@Value("${token.secrect.keys}")
	private String strKey;
	private final long time = 8*60*60*1000;
	
	public String generateToken(String data) {
//		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//		
//		String strKey = Encoders.BASE64.encode(key.getEncoded());
//		System.out.println("Kiemtra " + strKey);
		
		SecretKey key = 
				Keys.hmacShaKeyFor(Decoders.BASE64.decode(strKey));
		Date currentDate = new Date();
		long miliCurrentDate = currentDate.getTime();
		long miliFuture = miliCurrentDate +time;
		Date fureDate = new Date(miliFuture);
		String token = Jwts.builder()
				.signWith(key)
				.setSubject(data)
				.setExpiration(fureDate)
				.compact();
		
		return token;
	}
}
