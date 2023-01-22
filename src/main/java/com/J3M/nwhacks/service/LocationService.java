package com.J3M.nwhacks.service;

import com.J3M.nwhacks.repository.LocationRepository;
import com.J3M.nwhacks.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    private final PersonRepository personRepository;

    public String ping() {
        return "pong!";
    }

    public void subscribe(Long personId, List<Long> subLocationIds) {
        var person = personRepository.findById(personId).orElseThrow();
        var locations = subLocationIds.stream().map(locationRepository::findById).filter(Optional::isPresent).map(Optional::get).toList();

        person.getSubscribedLocations().addAll(locations);
        locations.forEach(location -> location.getListeningPeople().add(person));

        personRepository.save(person);
        locationRepository.saveAll(locations);
    }

    public void unsubscribe(Long personId, List<Long> unsubLocationIds) {
        var person = personRepository.findById(personId).orElseThrow();
        var locations = unsubLocationIds.stream().map(locationRepository::findById).filter(Optional::isPresent).map(Optional::get).toList();

        locations.forEach(person.getSubscribedLocations()::remove);
        locations.forEach(location -> location.getListeningPeople().remove(person));

        personRepository.save(person);
        locationRepository.saveAll(locations);
    }
}
