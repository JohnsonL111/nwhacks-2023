package com.J3M.nwhacks.controller;

import com.J3M.nwhacks.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final LocationRepository locationRepository;

    @GetMapping("/message")
    public String sendMessage() {
        return "msg";
    }



}
