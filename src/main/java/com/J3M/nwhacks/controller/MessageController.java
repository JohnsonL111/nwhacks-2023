package com.J3M.nwhacks.controller;

import com.J3M.nwhacks.service.MessagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class MessageController {
    // dependency injection via requiredArgsConstructor @ param
    private final MessagingService messageService;
    public static final String ACCOUNT_SID = "AC254c116cf838956a559ddce050c844cc";
    public static final String AUTH_TOKEN = "7e8cf58fce530662f7a932690aa3234a";

    // testing endpoint
    @GetMapping("/message")
    public void sendMessage() {
        // testing endpoint
        // List<String> contactPeopleNumbers, String personOfInterest, String location
        // person of interest moved to location
        messageService.messagePeople(List.of("+16043792278", "+16044423403"), "bob", "vancouver");
    }
}
