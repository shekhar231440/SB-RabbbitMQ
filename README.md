# SB-RabbbitMQ
This project contains to spring-boot applications, one to produce JSON messages to Rabbit MQ and another to consume those messages. One queue and one exchange (topic exchange) has been created and based on routing key both are binded.
There are 4 types of exchnages supported by Rabbit MQ
  - Direct Exchange (delivers message to the queue with which it found exact match of routing-key)
  - Fanout Exchange (broadcast message copies to all binded queues, routing-key is irrelevent and ignored)
  - Topic Exchange (delivers message to one or more queues for which routting-key matches partially or completely)
  - Headers Exchange (delivers message to one or more queues for which header matches with specified values by binding queue)
