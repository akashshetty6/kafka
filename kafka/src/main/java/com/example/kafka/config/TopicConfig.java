package com.example.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

	@Bean
	NewTopic getNewTopic() {
		return  TopicBuilder.name("Hello").build() ;
	}
	
	@Bean
	NewTopic getNewJsonTopic() {
		return  TopicBuilder.name("Hello_Json").build() ;
	}
}
