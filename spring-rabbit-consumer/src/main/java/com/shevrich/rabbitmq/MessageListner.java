package com.shevrich.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.shevrich.rabbitmq.config.MQConfig;
import com.shevrich.rabbitmq.message.CustomMessage;

@Component
public class MessageListner {

	@RabbitListener(queues = MQConfig.QUEUE)
	public void listenMessage(CustomMessage message) {
		
		System.out.println(message);
	}
}
