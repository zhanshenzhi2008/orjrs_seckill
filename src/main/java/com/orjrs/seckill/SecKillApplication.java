package com.orjrs.seckill;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Slf4j
public class SecKillApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SecKillApplication.class, args);
    }

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    private final CountDownLatch latch = new CountDownLatch(3);

    @Override
    public void run(String... args) throws Exception {
        this.kafkaTemplate.send("test", "foo1");
        this.kafkaTemplate.send("test", "foo2");
        this.kafkaTemplate.send("test", "foo3");
        latch.await(60, TimeUnit.SECONDS);
        log.info("All received");
    }

    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        log.info(cr.toString());
        latch.countDown();
    }
}
