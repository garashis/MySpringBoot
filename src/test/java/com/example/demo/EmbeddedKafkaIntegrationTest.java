package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DirtiesContext
@ExtendWith(OutputCaptureExtension.class)
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
class EmbeddedKafkaIntegrationTest {
//    @Container
//    static final KafkaContainer kafka = new KafkaContainer(
//            DockerImageName.parse("confluentinc/cp-kafka:7.3.3")
//    );
//
//    @DynamicPropertySource
//    static void overrideProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.kafka.bootstrap-servers", kafka::getBootstrapServers);
//    }

    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private KafkaConsumerExample kafkaConsumerExample;
    @Test
    void shouldHandleProductPriceChangedEvent(CapturedOutput output)
            throws InterruptedException {
        String vehicle = "Mercedes E Class 2020";
        kafkaProducer.sendMessage(vehicle, "quickstart-events");
        assertTrue(kafkaConsumerExample.getCountDownLatch()
                .await(2, TimeUnit.SECONDS)
        );
        String message = output.getOut();
        assertTrue(message
                .contains("Received vehicle: Mercedes E Class 2020")
        );

    }
}
