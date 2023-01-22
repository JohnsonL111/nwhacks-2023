package com.J3M.nwhacks.service;

import com.J3M.nwhacks.model.Person;
import com.J3M.nwhacks.repository.LocationRepository;
import com.J3M.nwhacks.repository.PersonRepository;
import liquibase.pro.packaged.R;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final LocationRepository locationRepository;
    private final MessagingService messagingService;

    public void movePerson(Long locationId, Long personId) {
        var location = locationRepository.findById(locationId).orElseThrow();
        var person = personRepository.findById(personId).orElseThrow();

        var listeningPeople = person.getListeningPeople();
        var listeningLocationPeople = location.getListeningPeople();

        var contactPeople = new HashSet<Person>();
        contactPeople.addAll(listeningPeople);
        contactPeople.addAll(listeningLocationPeople);

        var contactNumbers = contactPeople.stream().map(Person::getPhoneNumber).toList();

        messagingService.messagePeople(contactNumbers, person.getUsername(), location.getName());
    }
}
