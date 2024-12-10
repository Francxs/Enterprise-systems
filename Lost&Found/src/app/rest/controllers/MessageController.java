package app.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.components.MessageScheduler;

@RestController
public class MessageController {
    
    @Autowired
    private MessageScheduler messageScheduler;

    @PostMapping("/send-initial-message")
    public void sendInitialMessage(@RequestParam int foundID) {
        messageScheduler.sendInitialMessage(foundID);
    }
}
