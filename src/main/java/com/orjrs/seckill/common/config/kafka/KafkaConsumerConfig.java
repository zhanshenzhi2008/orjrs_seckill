package com.orjrs.seckill.common.config.kafka;

import lombok.Data;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * KafkaConsumerConfig
 *
 * @author orjrs
 * @date 2018-07-01 18:58
 */
@Configuration
@EnableKafka
@Data
public class KafkaConsumerConfig {
    /***//*
    @Value("${bootstrap.servers}")
    private String bootstrapServers;

    *//***//*
    @Value("${group.id}")
    private String groupId;

    *//***//*
    @Value("${enable.auto.commit}")
    private String enableAutoCommit;

    *//***//*
    @Value("${auto.commit.interval.ms}")
    private String autoCommitInterval;

    *//***//*
    @Value("${session.timeout.ms}")
    private String sessionTimeout;

    *//***//*
    @Value("${auto.offset.reset}")
    private String autoOffsetReset;*/

    /**
     * kafka消费工厂
     *
     * @return ConsumerFactory<Integer   ,       String>
     */
    @Bean("consumerFactory")
    public ConsumerFactory<Integer, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }

    /**
     * kafka消费属性配置及
     *
     * @return Map<String       ,               Object>
     */
    private Map<String, Object> consumerConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.135.128:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "defaultGroup");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
//        props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        return props;
    }
}
