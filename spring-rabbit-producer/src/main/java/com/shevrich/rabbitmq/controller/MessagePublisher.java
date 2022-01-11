package com.shevrich.rabbitmq.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shevrich.rabbitmq.config.MQConfig;
import com.shevrich.rabbitmq.message.CustomMessage;

@RestController
public class MessagePublisher {
	
	@Autowired
	private RabbitTemplate template;
	
	@PostMapping("/publish")
	public String publishMessage(@RequestBody CustomMessage message) {
		
		message.setMessageId(UUID.randomUUID().toString());
		message.setMessageDate(new Date());
		
		template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTINGKEY, message);
		
		return "Message Published successfully....";
	}

}
