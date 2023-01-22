package com.J3M.nwhacks.controller;

import com.J3M.nwhacks.service.MessagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@RestController
@RequiredArgsConstructor
public class MessageController {
    // dependency injection via requiredArgsConstructor @ param
    private final MessagingService messageService;
    public static final String ACCOUNT_SID = "AC254c116cf838956a559ddce050c844cc";
    public static final String AUTH_TOKEN = "7e8cf58fce530662f7a932690aa3234a";

    @GetMapping("/message")
    public String sendMessage() {
        // scrape all numbers

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        System.out.println(ACCOUNT_SID);
        System.out.println(AUTH_TOKEN);

        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+16043792278"),
                        new com.twilio.type.PhoneNumber("+16088796642"),
                        "Hi there")
                .create();

        return message.getSid();


        // List<String> contactPeopleNumbers, String personOfInterest, String location
        // messageService.messagePeople();
    }



}
