package com.J3M.nwhacks.controller;

import com.J3M.nwhacks.service.PersonService;
import liquibase.pro.packaged.P;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PatchMapping("/move/{locationId}")
    public ResponseEntity<String> movePerson(@PathVariable Long locationId, @RequestHeader Long personId) {
        personService.movePerson(locationId, personId);
        return ResponseEntity.ok().body("Moved successfully!");
    }

    @PutMapping("/login/{username}")
    public ResponseEntity<Long> login(@PathVariable String username) {
        return ResponseEntity.ok().body(personService.login(username));
    }

    @PostMapping("/login/{username}/{number}")
    public ResponseEntity<Long> createUser(@PathVariable String username, @PathVariable String number) {
        return ResponseEntity.ok().body(personService.createUser(username, number));
    }

    @GetMapping("/login/check/{username}")
    public ResponseEntity<Boolean> checkUsername(@PathVariable String username) {
        return ResponseEntity.ok().body(personService.checkUsername(username));
    }
}
