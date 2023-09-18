package com.ff.freight.controller;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ff.freight.service.KafkaService;

@RestController
public class MessageController {
    private static final String TOPIC_1="_TOPIC_1";
    private final KafkaService kafkaProducer;

    MessageController(KafkaService kafkaProducer){
      //  Properties properties = new Properties();
        this.kafkaProducer=kafkaProducer;
     /*   properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Replace with your Kafka broker(s)
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
      */
      //kafkaProducer = new KafkaProducer<>(properties);
    }

    @PostMapping("/publish")
    public void publishMessage(@RequestBody String message) {
        // Publish the message to the Kafka topic
       // ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_1, message);
       System.out.println(message);
        kafkaProducer.sendMessage(TOPIC_1,message);
    }

    @GetMapping("/pub")
    public String getMessage(@RequestParam String message){
      System.out.println(message);
      return message;
    }
}
