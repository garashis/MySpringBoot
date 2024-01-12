package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafKaConsumer {

    private final String TOPIC_NAME = "myTest";
    private final String GROUP_ID = "group_id";

    @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
    public void consume(String message) {
        log.info(String.format("Message received -> %s", message));
    }
}
