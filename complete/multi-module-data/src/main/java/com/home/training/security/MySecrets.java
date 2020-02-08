package com.home.training.security;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(SecretsProperties.class)
public class MySecrets {

	private final SecretsProperties secretsProperties;

	public MySecrets(SecretsProperties secretsProperties) {
		this.secretsProperties = secretsProperties;
	}
	
	public String GetUserName() {
		return this.secretsProperties.getUsername();
	}
}
