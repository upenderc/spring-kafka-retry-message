package com.poc.krm;

public interface KafkaAdapterStatusGateway {

	boolean isRunning(String command);
	void stopAdapter(String command);
	void startAdapter(String command);
}