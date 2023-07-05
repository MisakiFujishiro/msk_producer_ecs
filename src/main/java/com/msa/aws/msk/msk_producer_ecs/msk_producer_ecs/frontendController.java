package com.msa.aws.msk.msk_producer_ecs.msk_producer_ecs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class frontendController {
    @RequestMapping(value="/msk-producer", produces = "text/plain")
    public String frontend() {
        return "Hello msk-producer-from-ecs!";
    }
}

