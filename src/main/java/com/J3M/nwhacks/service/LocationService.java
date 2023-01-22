package com.J3M.nwhacks.service;

import com.J3M.nwhacks.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public String ping() {
        return "pong!";
    }
}
