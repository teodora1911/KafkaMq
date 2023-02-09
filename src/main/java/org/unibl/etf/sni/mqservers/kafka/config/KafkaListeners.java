package org.unibl.etf.sni.mqservers.kafka.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${users.topic.name}")
    private String usersTopicName;

//    @Value("${my.topic.name}")
//    private String myTopicName;

    @KafkaListener(topics = "${my.topic.name}", groupId = "sni")
    void listener(String data){
        System.out.println("Listener received: " + data);
        kafkaTemplate.send(usersTopicName, data);
    }
}
