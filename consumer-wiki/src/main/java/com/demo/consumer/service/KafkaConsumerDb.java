package com.demo.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.consumer.entity.WikimediaData;
import com.demo.consumer.repository.WikiRepo;

@Service
public class KafkaConsumerDb {

	private final static Logger logger=LoggerFactory.getLogger(KafkaConsumerDb.class);
	
	@Autowired
	private WikiRepo repo;
	
	@KafkaListener(topics="recentchange",groupId = "myGroup")
	public void consume(String eventMessage) {
//		logger.info(String.format("Message received -> %s", eventMessage));
		
		WikimediaData wikimediaData=new WikimediaData();
		wikimediaData.setWikiEventData(eventMessage);
		repo.save(wikimediaData);
	}
}
