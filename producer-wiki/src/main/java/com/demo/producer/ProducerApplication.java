package com.demo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.producer.service.WikimediaProducer;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {
	
	@Autowired
	private WikimediaProducer producer;
 
	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		producer.sendMessage();
		
	}

}
