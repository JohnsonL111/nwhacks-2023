package com.J3M.nwhacks.controller;

import com.J3M.nwhacks.service.PersonService;
import liquibase.pro.packaged.P;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
@CrossOrigin("http://localhost:3000")
public class PersonController {

    private final PersonService personService;

    @PatchMapping("/move")
    public ResponseEntity<String> movePerson(@RequestParam Long locationId, @RequestParam Long personId) {
        personService.movePerson(locationId, personId);
        return ResponseEntity.ok().body("Moved successfully!");
    }

    @PatchMapping("/remove")
    public ResponseEntity<String> removeLocation(@RequestParam Long personId) {
        personService.removePerson(personId);
        return ResponseEntity.ok().body("Removed successfully!");
    }

    @PutMapping("/login")
    public ResponseEntity<Long> login(@RequestParam String username) {
        return ResponseEntity.ok().body(personService.login(username));
    }

    @PostMapping("/login")
    public ResponseEntity<Long> createUser(@RequestParam String username, @RequestParam String number) {
        return ResponseEntity.ok().body(personService.createUser(username, number));
    }

    @GetMapping("/login/check")
    public ResponseEntity<Boolean> checkUsername(@RequestParam String username) {
        return ResponseEntity.ok().body(personService.checkUsername(username));
    }
}
