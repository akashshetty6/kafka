package com.example.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.clients.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

//	@Autowired
	private KafkaProducer kafkaProducer;
	
	
public MessageController(KafkaProducer kafkaProducer) {
	
	this.kafkaProducer = kafkaProducer;
}


//	http://localhost:8080/api/v1/kafka/publish?message=helloworld 
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam String message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("message sent to the topic");
	}
	
}
