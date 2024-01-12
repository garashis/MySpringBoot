package com.example.demo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Slf4j
@Service
@Data
public class KafkaConsumerExample {
    private final CountDownLatch countDownLatch = new CountDownLatch(1);
    @KafkaListener(topics = "quickstart-events", groupId = "integration")
    public void listen(String vehicleMessage) {
        log.info(String.format(
                        "Received vehicle: %s", vehicleMessage
                )
        );
        countDownLatch.countDown();
    }
}