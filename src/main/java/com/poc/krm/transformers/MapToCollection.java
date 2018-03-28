package com.poc.krm.transformers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

@Component
public class MapToCollection {

	@Transformer(inputChannel="processChannel", outputChannel="processChannel")
	public List<String> transform(Map<String, Map<Integer, List<String>>> kafkaMessage) {
		
		Map<Integer, List<String>> partitionMessages=kafkaMessage.entrySet().stream().findFirst().get().getValue();
		return partitionMessages.values().stream().flatMap(List::stream).collect(Collectors.toList());
	}
}
