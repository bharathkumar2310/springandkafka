package com.ecomerce.project.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ecomerce.project.category.categoryModel;

@Service
public class kafkaJsonConsumer {


	  private static final Logger LOG = LoggerFactory.getLogger(kafkaJsonConsumer.class);

// for kafkaListener @Value wont work for {spring.kafka.topic.name}
	    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "myGroup")
	    public void consume(categoryModel message) {
			
			LOG.info(String.format("message received -> %s", message.toString()));
			
			
		}
}
