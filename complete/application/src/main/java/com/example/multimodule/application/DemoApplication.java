package com.example.multimodule.application;

import com.example.multimodule.service.MyService;
import com.home.training.security.MySecrets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.example.multimodule", "com.home.training.security"})
@RestController
public class DemoApplication {

	private final MyService myService;
	private final MySecrets mySecrets;
	

	public DemoApplication(MyService myService, MySecrets mySecrets) {
		this.myService = myService;
		this.mySecrets = mySecrets;
	}

	@GetMapping("/")
	public String home() {
		return myService.message();
	}

	@GetMapping("/GetSecret")
	public String GetSecret() {
		return mySecrets.GetUserName();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
