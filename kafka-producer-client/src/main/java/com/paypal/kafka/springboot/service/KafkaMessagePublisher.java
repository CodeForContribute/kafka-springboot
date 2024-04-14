package com.paypal.kafka.springboot.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Log4j2
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String,Object>kafkaTemplate;

    public void sendMessageToTopic(String message){
        CompletableFuture<SendResult<String,Object>>future = kafkaTemplate.send("radha-madhav", message);
        //future.get();
        future.whenComplete((result,err)->{
            String topic = result.getRecordMetadata().topic();
            log.info("topic:{}",topic);
            if (err == null){
                log.info("Sent message = [{}] with offset = [{}", message, result.getRecordMetadata().offset());
            }else{
                log.info("Unable to send message =[{}] due to : {}", message, err.getMessage());
            }
        });
    }

}
