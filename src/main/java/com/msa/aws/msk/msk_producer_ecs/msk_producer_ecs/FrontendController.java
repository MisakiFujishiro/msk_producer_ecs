package com.msa.aws.msk.msk_producer_ecs.msk_producer_ecs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FrontendController {
    private final MessageSender messageSender;

    @Autowired
    public FrontendController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @PostMapping("/msk-producer-send")
    public ResponseEntity<String> sendMessage(@RequestParam("num") int num, @RequestParam("topic") String topic, @RequestParam("partition_num") int partition_num) {
        if (num <= 0 || partition_num <= 0) {
            return ResponseEntity.badRequest().body("Invalid number of messages or partition number. Only positive integers are allowed.");
        }

        messageSender.sendRandomMessagesToTopic(topic, num, partition_num);
        return ResponseEntity.ok("Messages sent: " + num);
    }
}
