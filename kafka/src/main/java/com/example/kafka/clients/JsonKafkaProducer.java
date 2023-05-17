package com.example.kafka.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.kafka.model.User;

@Service
public class JsonKafkaProducer {

	private final static Logger logger=LoggerFactory.getLogger(KafkaProducer.class);
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	
	public void sendUser(User user) {
	
		logger.info(String.format("user data sent -> %s", user.toString()));
		Message<User> message=MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, "Hello_Json").build();
		
		kafkaTemplate.send(message);
	
	}
	
}
