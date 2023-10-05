package edu.poly.finalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class CozastoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CozastoreApplication.class, args);
	}

}
