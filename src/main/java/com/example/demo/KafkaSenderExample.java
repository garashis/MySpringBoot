package com.example.demo;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
class KafkaSenderExample {

    private KafkaTemplate<String, String> kafkaTemplate;

    KafkaSenderExample(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    ListenableFuture<SendResult<String, String>> sendMessage(String message, String topicName) {
        return kafkaTemplate.send(topicName, message);
    }
}