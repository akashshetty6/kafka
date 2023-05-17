package com.example.kafka.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	private final static Logger logger=LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics = "Hello",groupId = "myGroup")
	public void consume(String message) {
		logger.info(String.format("message consumed is %s", message));
		
	}

}
