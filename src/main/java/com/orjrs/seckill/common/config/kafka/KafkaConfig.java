package com.orjrs.seckill.common.config.kafka;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

/**
 * Kafka Config
 *
 * @author orjrs
 * @date 2018-07-01 18:56
 */
@Configuration
@EnableKafka
public class KafkaConfig {

    @Bean
    public ConcurrentKafkaListenerContainerFactory<Integer, String> kafkaListenerContainerFactory(
            @Qualifier("consumerFactory") ConsumerFactory<Integer, String> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

    @Bean("kafkaTemplate")
    public KafkaTemplate<Integer, String> kafkaTemplate(@Qualifier("producerFactory") ProducerFactory<Integer, String>
                                                                producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}
