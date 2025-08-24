package vn.edu.fpt.sblog_post_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SblogPostServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SblogPostServiceApplication.class, args);
	}

}
