package com.ecomerce.project.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.ecomerce.project.category.categoryModel;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class kafkaJsonProducer {
	
	@Value("${spring.kafka.topic.name}")
	private String kafkaJsonTopic;

	 private static final Logger LOG = LoggerFactory.getLogger(kafkaJsonProducer.class);

		
		@Autowired
		private KafkaTemplate<String,categoryModel>kafkaTemplate;
		
		public void sendMessage(categoryModel data) {
			
		 

			
			Message<categoryModel>message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, kafkaJsonTopic).build();
			
			LOG.info(String.format("message Sent -> %s", data.toString()));
			
			kafkaTemplate.send(message);
			
		}
}
