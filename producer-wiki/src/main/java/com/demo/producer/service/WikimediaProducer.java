package com.demo.producer.service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.demo.producer.handler.WikimediaChangesHandler;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class WikimediaProducer {

	private final static Logger logger=LoggerFactory.getLogger(WikimediaProducer.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage() throws InterruptedException {
		String topic="recentchange";
		
		EventHandler eventHandler=new WikimediaChangesHandler(kafkaTemplate, topic);
		
		String url="https://stream.wikimedia.org/v2/stream/recentchange";
		EventSource.Builder builder=new EventSource.Builder(eventHandler, URI.create(url));
		
		EventSource eventSource=builder.build();
		eventSource.start();
		
		TimeUnit.MINUTES.sleep(10);
		
	}

	
}
