package com.example.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.clients.JsonKafkaProducer;
import com.example.kafka.model.User;

@RestController
@RequestMapping("/json")
public class JsonMessageController {

	@Autowired
	private JsonKafkaProducer jsonKafkaProducer;
	
	@PostMapping("/publish")
	public ResponseEntity<String> publisj(@RequestBody User user){
		jsonKafkaProducer.sendUser(user);
		return ResponseEntity.ok("user sent to the topic");
	}
}
