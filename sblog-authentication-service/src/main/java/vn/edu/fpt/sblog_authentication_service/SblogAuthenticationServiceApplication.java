package vn.edu.fpt.sblog_authentication_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SblogAuthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SblogAuthenticationServiceApplication.class, args);
	}

}
