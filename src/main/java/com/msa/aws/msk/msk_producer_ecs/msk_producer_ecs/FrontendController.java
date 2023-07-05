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

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        messageSender.sendMessage(message);
        return ResponseEntity.ok("Message sent: " + message);
    }
}
