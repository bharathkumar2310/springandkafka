package com.ecomerce.project.kafkaconfig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class kafkaTopicConfig {

	@Value("${spring.kafka.topic.name}")
	private String kafkaJsonTopic;
	
	@Bean
	public NewTopic kafkaTopic() {
		
		return TopicBuilder.name("kafkaTopic").build();
		
	}
	
	@Bean
	public NewTopic kafkaJsonTopic() {
		
		return TopicBuilder.name(kafkaJsonTopic).build();
		
	}
}
