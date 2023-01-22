package com.J3M.nwhacks.controller;

import com.J3M.nwhacks.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PatchMapping("/move/{locationId}")
    public ResponseEntity<String> movePerson(@PathVariable Long locationId, @RequestHeader Long personId) {
        personService.movePerson(locationId, personId);
        return ResponseEntity.ok().body("Moved successfully!");
    }
}
