package com.msa.aws.msk.msk_producer_ecs.msk_producer_ecs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class MessageSender {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;

    @Autowired
    public MessageSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = "Topic_from_java"; // 送信先のトピック名
    }

    public void sendMessage(String message) {
        kafkaTemplate.send(topic, message);
    }

    public void sendRandomMessages(int num) {
        Random rand = new Random();

        for (int i = 0; i < num; i++) {
            int randomNum = rand.nextInt(11);
            kafkaTemplate.send("your_topic_name", String.valueOf(randomNum));
        }
    }
}