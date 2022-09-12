package br.com.fiap.broker.dronemonitorconsumer.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.JsonMessageConverter;

import java.util.HashMap;

@Slf4j
@EnableKafka
@Configuration
public class ConsumerKafkaConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public ConsumerFactory jsonConsumerFactory() {
        var configs = new HashMap<String, Object>();

        //configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getConsumer().getBootstrapServers());
        configs.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, kafkaProperties.getSecurity().getProtocol());
        configs.put(SaslConfigs.SASL_JAAS_CONFIG, kafkaProperties.getProperties().get(SaslConfigs.SASL_JAAS_CONFIG));
        configs.put(SaslConfigs.SASL_MECHANISM, kafkaProperties.getProperties().get(SaslConfigs.SASL_MECHANISM));
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        configs.put(ConsumerConfig.ALLOW_AUTO_CREATE_TOPICS_CONFIG, true);
        return new DefaultKafkaConsumerFactory<>(configs);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory jsonKafkaListenerContainerFactory() {
        var factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(jsonConsumerFactory());
        factory.setMessageConverter(new JsonMessageConverter());
        return factory;
    }
}
