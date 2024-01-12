package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class KafkaController {
    public static final String TOPIC_NAME = "myTest";

    private final KafkaProducer kafkaProducer;
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        ListenableFuture<SendResult<String, String>> future = kafkaProducer.sendMessage(TOPIC_NAME, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Message [{}] delivered with offset " +
                        message +
                        result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to deliver message " +
                        message +
                        ex.getMessage());
            }
        });

        return ResponseEntity.ok("Message sent to kafka topic: " + message);
    }
}
