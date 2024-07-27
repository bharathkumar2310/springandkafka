package com.ecomerce.project.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaConsumer{
	
    private static final Logger LOG = LoggerFactory.getLogger(kafkaConsumer.class);


    @KafkaListener(topics = "kafkaTopic", groupId = "myGroup")
    public void consume(String message) {
		
		LOG.info(String.format("message received %s", message));
		
		
	}
	
}
