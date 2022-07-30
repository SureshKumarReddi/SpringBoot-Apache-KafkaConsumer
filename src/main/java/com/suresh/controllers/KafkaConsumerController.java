package com.suresh.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.models.User;

@RestController
public class KafkaConsumerController {

	
	List<String> messages = new ArrayList<>();
	
	User user = null;
	
	@GetMapping("/consumeStringMessage")
	public List<String> consumeMsg() {
		return messages;
	}
	@KafkaListener(groupId = "javatechie-1", topics = "javatechie1", containerFactory = "kafkaListenerContainerFactory")
	public List<String> getMsgFromTopic(String data) {
		messages.add(data);
		return messages;
	}
	
	
	@GetMapping("/consumeJsonMessage")
	public User getJsonFromTopic() {
		return user;
	}
	
	@KafkaListener()
	public User getJsonMessage(User user) {
		
		return user;
	}
	
}
