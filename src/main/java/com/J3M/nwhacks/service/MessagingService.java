package com.J3M.nwhacks.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessagingService {
    public static final String ACCOUNT_SID = "AC254c116cf838956a559ddce050c844cc";
    public static final String AUTH_TOKEN = "e1a1bb8dce42c897f548677c100a59f6";

    public void messagePeople(List<String> contactPeopleNumbers, String personOfInterest, String location) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        contactPeopleNumbers = contactPeopleNumbers.stream().distinct().toList();

          // loop through numbers and send them message
         for (String number : contactPeopleNumbers) {
            Message message = Message.creator(
                            new com.twilio.type.PhoneNumber(number),
                            new com.twilio.type.PhoneNumber("+16088796642"),
                            String.format("%s is currently at %s", personOfInterest, location))
                    .create();
        }
    }
}
