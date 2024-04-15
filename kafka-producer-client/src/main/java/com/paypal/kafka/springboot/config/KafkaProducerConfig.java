package com.paypal.kafka.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("radha-madhav",5,(short) 1);
    }

    @Bean
    public NewTopic createTopic2(){
        return new NewTopic("radha-madhav-2",3,(short) 1);
    }
}
