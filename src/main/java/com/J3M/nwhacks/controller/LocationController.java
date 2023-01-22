package com.J3M.nwhacks.controller;

import com.J3M.nwhacks.model.Location;
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
    public ResponseEntity<String> subscribe(@RequestParam Long personId, @RequestParam List<String> locationStrings) {
        locationService.subscribe(personId, locationStrings);
        return ResponseEntity.ok().body("Removed successfully!");
    }

    @PatchMapping("/unsubscribe")
    public ResponseEntity<String> unsubscribe(@RequestParam Long personId, @RequestParam List<String> locationStrings) {
        locationService.unsubscribe(personId, locationStrings);
        return ResponseEntity.ok().body("Removed successfully!");
    }

    @GetMapping()
    public List<Location> getLocations() {
        return locationService.getAll();
    }
}
