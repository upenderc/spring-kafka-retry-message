package com.poc.krm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableIntegration
@EnableScheduling
@ImportResource(value={"/kafka-consumer-config.xml"})
@ComponentScan(basePackages={"com.poc.krm"})
public class KafkaRetryMessageApplication {

	public static void main(String ...args) {
		SpringApplication.run(KafkaRetryMessageApplication.class, args);
	}
}
