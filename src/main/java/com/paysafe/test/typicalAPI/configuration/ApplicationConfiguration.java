package com.paysafe.test.typicalAPI.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {
	
	@Value("${paysafe.url}")
	private String url;
	
	@Value("${paysafe.user}")
	private String user;
	
	@Value("${paysafe.password}")
	private String password;
	

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public String getUrl() {
		return url;
	}


	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

}
