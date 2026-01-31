package com.mitocode.microservice.product_service.util;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaUtil {
    private final KafkaTemplate<String,String> kafkaTemplate;

    @Value("${kafka.mitocode.topic:default}")
    private String topicName;

    public void sendMessage(String message){
        kafkaTemplate.send(topicName, message);
    }
}
