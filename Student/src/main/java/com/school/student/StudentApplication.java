package com.school.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class StudentApplication {

	//Using RestTemplate
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	//Using WebFlux/WebClient
	/*@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

}
