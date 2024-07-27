package com.ecomerce.project.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class kafkaProducer {
	
    private static final Logger LOG = LoggerFactory.getLogger(kafkaProducer.class);

	
	@Autowired
	private KafkaTemplate<String,String>kafkaTemplate;
	
	public void sendMessage(String message) {
		
		LOG.info(String.format("message Sent %s", message));
		
		kafkaTemplate.send("kafkaTopic", message);
		
	}

}
