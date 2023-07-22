package com.msa.aws.msk.msk_producer_ecs.msk_producer_ecs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class MessageSender {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;

    @Autowired
    public MessageSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = "Topic_P5"; // 送信先のトピック名
    }

    public void sendMessage(String message) {
        String randomKey = UUID.randomUUID().toString();
        kafkaTemplate.send(topic, randomKey, message);
    }
    public void sendRandomMessagesToTopic(String topic, int num, int partition_num) {
        Random rand = new Random();
        System.out.print(num);
        for (int i = 0; i < num; i++) {
            int randomNum = rand.nextInt(11);
            System.out.print(randomNum);
            String partitionKey = String.valueOf(i % partition_num); // create partition key
            kafkaTemplate.send(topic, partitionKey, String.valueOf(randomNum));
        }
    }
}