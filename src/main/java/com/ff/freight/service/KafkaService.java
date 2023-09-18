package com.ff.freight.service;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service
@EnableKafka
public class KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    @KafkaListener(topics = "_TOPIC_1", groupId = "consumer-my-group-1")
    public void receiveMessage(String message) {
        // Handle received messages
         System.out.println("message receipved : :"+message);
    }
}
