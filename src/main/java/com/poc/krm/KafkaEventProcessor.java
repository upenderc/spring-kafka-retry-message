package com.poc.krm;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
@Component
public class KafkaEventProcessor {

	private static final Logger LOG = Logger.getLogger(KafkaEventProcessor.class);
	@ServiceActivator(inputChannel="processChannel")
	public void onMessage(List<String> message) {
		LOG.info("Received "+message);
	}
}
