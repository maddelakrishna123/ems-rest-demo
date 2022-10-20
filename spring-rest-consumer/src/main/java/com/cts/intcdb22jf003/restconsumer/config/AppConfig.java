package com.cts.intcdb22jf003.restconsumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.cts.intcdb22jf003.restconsumer")
public class AppConfig {
@Bean
	public RestTemplate temaplate()
	{
		return new RestTemplate();
	}
}
