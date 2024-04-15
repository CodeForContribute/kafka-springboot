package com.paypal.kafka.consumerclient.consumer;

import com.paypal.kafka.consumerclient.dto.Customer;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaMessageListener {

    @KafkaListener(topics = {"radha-madhav-2"},groupId = "radhe-radhe")
    public void consumer1(Customer customer){
        try {
            log.info("consumer1 consumed message:{}",customer.toString());
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @KafkaListener(topics = {"radha-madhav"},groupId = "radhe-radhe")
    public void consumer2(String message){
        try {
            log.info("consumer2 consumed message:{}",message);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @KafkaListener(topics = {"radha-madhav"},groupId = "radhe-radhe")
    public void consumer3(String message){
        try {
            log.info("consumer3 consumed message:{}",message);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @KafkaListener(topics = {"radha-madhav"},groupId = "radhe-radhe")
    public void consumer4(String message){
        try {
            log.info("consumer4 consumed message:{}",message);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @KafkaListener(topics = {"radha-madhav"},groupId = "radhe-radhe")
    public void consumer5(String message){
        try {
            log.info("consumer5 consumed message:{}",message);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
