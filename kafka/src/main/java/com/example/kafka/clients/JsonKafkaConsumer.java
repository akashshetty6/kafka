package com.example.kafka.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import com.example.kafka.model.User;

public class JsonKafkaConsumer {

	private final static Logger logger=LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	
	@KafkaListener(topics = "Hello_Json",groupId = "myGroup")
	public void consume_Json(User user) {
		logger.info(String.format("message consumed is %s", user.toString()));
		
	}
}
