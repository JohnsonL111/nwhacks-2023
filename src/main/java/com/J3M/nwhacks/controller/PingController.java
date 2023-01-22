package com.J3M.nwhacks.controller;

import com.J3M.nwhacks.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PingController {

    private final LocationService locationService;

    @GetMapping("/ping")
    public String ping() {
        return locationService.ping();
    }
}
