package com.J3M.nwhacks.service;

import com.J3M.nwhacks.model.Person;
import com.J3M.nwhacks.repository.LocationRepository;
import com.J3M.nwhacks.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final LocationRepository locationRepository;
    private final MessagingService messagingService;

    public void movePerson(String locationString, Long personId) {
        var location = locationRepository.findByIdentifierName(LocationService.createIdentifier(locationString)).orElseThrow();
        var person = personRepository.findById(personId).orElseThrow();

        var listeningPeople = person.getListeningPeople();
        var listeningLocationPeople = location.getListeningPeople();

        var contactPeople = new HashSet<Person>();
        contactPeople.addAll(listeningPeople);
        contactPeople.addAll(listeningLocationPeople);

        var contactNumbers = contactPeople.stream().map(Person::getPhoneNumber).toList();

        messagingService.messagePeople(contactNumbers, person.getUsername(), location.getName());

        person.setCurrentLocation(location);
        location.getCurrentPeople().add(person);

        locationRepository.save(location);
        personRepository.save(person);
    }

    public Long login(String username) {
        var person  = personRepository.findPersonByUsername(username).orElseThrow();
        return person.getId();
    }

    public Long createUser(String username, String number) {
        var newUser = personRepository.save(
                Person.builder()
                        .username(username)
                        .phoneNumber(number)
                        .build());

        return newUser.getId();
    }

    public Boolean checkUsername(String username) {
        return personRepository.existsByUsername(username);
    }

    public void removePerson(Long personId) {
        var person = personRepository.findById(personId).orElseThrow();
        var location = person.getCurrentLocation();
        person.setCurrentLocation(null);

        if (location != null) {
            location.getCurrentPeople().remove(person);
            locationRepository.save(location);
        }
        personRepository.save(person);
    }

    public void subscribe(Long personId, List<Long> subscribePersonIds) {
        var person = personRepository.findById(personId).orElseThrow();
        var subscribePeople = subscribePersonIds.stream()
                .map(personRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(sub -> !person.getSubscribedPeople().contains(sub))
                .toList();

        person.getSubscribedPeople().addAll(subscribePeople);
        personRepository.save(person);
    }

    public void unsubscribe(Long personId, List<Long> unsubscribePersonId) {
        var person = personRepository.findById(personId).orElseThrow();
        var unsubscribePeople = unsubscribePersonId.stream().map(personRepository::findById).filter(Optional::isPresent).map(Optional::get).toList();

        person.getSubscribedPeople().removeAll(unsubscribePeople);
        personRepository.save(person);
    }
}
