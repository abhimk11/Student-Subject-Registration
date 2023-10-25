package com.notificationservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@KafkaListener(topics = "notificationTopic")
	public void handleNotification(StudentPlacedEvent studentPlacedEvent){
		log.info("Received Notification for - {} {} {}",studentPlacedEvent.getFirstName()
				,studentPlacedEvent.getLastName()
				,studentPlacedEvent.getRoll_no());
	}
}
