package com.cts.intcdb22jf003.restconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringRestConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestConsumerApplication.class, args);
	}

}
