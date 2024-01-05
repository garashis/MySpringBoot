package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class KafkaController {

    private final KafkaSenderExample kafkaSenderExample;

    @GetMapping("/sendMessage")
    void sendMessageWithCallback() {
        String message = "hello";
        ListenableFuture<SendResult<String, String>> future =
                kafkaSenderExample.sendMessage(message, "quickstart-events");

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
    }
}
