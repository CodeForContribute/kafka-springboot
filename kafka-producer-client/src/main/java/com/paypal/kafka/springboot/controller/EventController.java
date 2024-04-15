package com.paypal.kafka.springboot.controller;

import com.paypal.kafka.springboot.dto.Customer;
import com.paypal.kafka.springboot.service.KafkaMessagePublisher;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Data
@RestController
@RequestMapping("/producer-app")
@Log4j2
public class EventController {

    private KafkaMessagePublisher kafkaMessagePublisher;

    public EventController(@Autowired KafkaMessagePublisher kafkaMessagePublisher) {
        this.kafkaMessagePublisher = kafkaMessagePublisher;
    }

    @PostMapping("/publish/{message}/{times}")
    public ResponseEntity<?> publishMessage(@PathVariable String message,
                                            @PathVariable int times) {
        try {
            for (int i = 0; i < times; ++i) {
                this.kafkaMessagePublisher.sendMessageToTopic(message + "-" + i);
            }
            log.info("message : {} published successfully !!", message);
            return ResponseEntity.ok("message published successfully >>>>");
        } catch (Exception e) {
            log.error("Error publishing message : {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/publish")
    public void sendEvents(@RequestBody Customer customer){
        this.kafkaMessagePublisher.sendEvents(customer);
    }
}
