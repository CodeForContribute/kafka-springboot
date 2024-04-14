package com.paypal.kafka.consumerclient.consumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaMessageListener {

    @KafkaListener(topics = {"radha-madhav"},groupId = "radhe-radhe")
    public void consume(String message){
        try {
            log.info("consumed message:{}",message);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
