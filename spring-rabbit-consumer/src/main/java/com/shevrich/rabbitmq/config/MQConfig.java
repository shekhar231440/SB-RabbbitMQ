package com.shevrich.rabbitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

@Configuration
public class MQConfig {
	
	public static final String QUEUE = "message_queue";
	public static final String EXCHANGE = "message_exchange";
	public static final String ROUTINGKEY = "route_01";
	
	
	@Bean
	public Queue getQueue() {		
		
		return new Queue(QUEUE);
	}

	@Bean
	public TopicExchange getTopicExchange() {
		
		return new TopicExchange(EXCHANGE);
	}
	
	@Bean
	public Binding binding(Queue queue, TopicExchange topicExchange) {
		
		return BindingBuilder
				.bind(queue)
				.to(topicExchange)
				.with(ROUTINGKEY);
	}
	
	@Bean
	public MessageConverter messageConverter() {
		
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(messageConverter());
		
		return template;
	}
	
	
}
