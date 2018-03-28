package com.poc.krm;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component(value="retryTopicSchedulerTask")
public class KafkaRetryTopicSchedulerTask {
	private static final Logger LOG = Logger.getLogger(KafkaRetryTopicSchedulerTask.class);
	
	@Autowired
	private KafkaInboundAdapterController adapterController;
	private boolean initialState=true;
	@Scheduled(fixedRate=30000)
	public void enableAdapter() {
		LOG.info("Scheduler Started ");
		//boolean state=adapterController.isRunning("@retryInboundChannelAdapter.isRunning()");
		if (!initialState) {
			adapterController.enableKafkaAdapter("@retryInboundChannelAdapter.start()");
				initialState=true;
		} else {
				adapterController.disableKafkaAdapter("@retryInboundChannelAdapter.stop()");
				initialState=false;
			
		}
	}
	
}
