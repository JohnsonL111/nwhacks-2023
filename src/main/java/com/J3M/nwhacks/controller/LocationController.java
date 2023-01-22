package com.J3M.nwhacks.controller;

import com.J3M.nwhacks.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PatchMapping("/subscribe")
    public ResponseEntity<String> subscribe(@RequestParam Long personId, @RequestParam List<Long> subLocationIds) {
        locationService.subscribe(personId, subLocationIds);
        return ResponseEntity.ok().body("Removed successfully!");
    }

    @PatchMapping("/unsubscribe")
    public ResponseEntity<String> unsubscribe(@RequestParam Long personId, @RequestParam List<Long> unsubLocationIds) {
        locationService.unsubscribe(personId, unsubLocationIds);
        return ResponseEntity.ok().body("Removed successfully!");
    }
}
