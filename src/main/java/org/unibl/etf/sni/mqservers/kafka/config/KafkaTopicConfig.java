package org.unibl.etf.sni.mqservers.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${users.topic.name}")
    private String usersTopicName;

    @Value("${my.topic.name}")
    private String myTopicName;

    @Bean
    public NewTopic usersTopic() {
        return TopicBuilder.name(usersTopicName).build();
    }

    @Bean
    public NewTopic myTopic(){
        return TopicBuilder.name(myTopicName).build();
    }
}
