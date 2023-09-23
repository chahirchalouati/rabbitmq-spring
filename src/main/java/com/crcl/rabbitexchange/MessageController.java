package com.crcl.rabbitexchange;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MessageController {

    private final MessageProducer messageProducer;

    @PostMapping("/send")
    public String sendMessage(@RequestBody Message message) {
        messageProducer.sendMessage(message.message());
        return "Message sent: " + message;
    }
}
