package com.poc.krm;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaInboundAdapterController {
	private static final String COMMAND_RECEIVED = "Command Received - ";

	private static final Logger LOG=Logger.getLogger(KafkaInboundAdapterController.class);
	
	@Autowired
	private KafkaAdapterStatusGateway statusGateway;
	
	public void enableKafkaAdapter(String enableCommand) {
		LOG.info(COMMAND_RECEIVED+enableCommand);
		statusGateway.startAdapter(enableCommand);
		LOG.info("Adapter State: started");
	}
	public void disableKafkaAdapter(String disableCommand) {
		LOG.info(COMMAND_RECEIVED+disableCommand);
		statusGateway.stopAdapter(disableCommand);
		LOG.info("Adapter State: stoped");
	}
	public boolean isRunning(String command) {
		LOG.info(COMMAND_RECEIVED+command);
		boolean state=statusGateway.isRunning(command);
		LOG.info(" Adapter State: "+state);
		return state;
	}
}
