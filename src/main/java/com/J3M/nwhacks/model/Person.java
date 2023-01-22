package com.J3M.nwhacks.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
@Data
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @ManyToOne
    @JoinColumns({
                    @JoinColumn(name = "currentLocationId", referencedColumnName = "id"),
                    @JoinColumn(name = "currentLocationName", referencedColumnName = "name")
            })
    private Location currentLocation;

    @ManyToMany
    @JoinTable(name = "subscribedLocations")
    private List<Location> subscribedLocations;

    @ManyToMany
    @JoinTable(
            name = "subscribedPersons",
            joinColumns = @JoinColumn(name = "subscribed_person"),
            inverseJoinColumns = @JoinColumn(name = "listening_person"))
    private List<Person> subscribedPeople;

    @ManyToMany
    @JoinTable(
            name = "subscribedPersons",
            joinColumns = @JoinColumn(name = "listening_person"),
            inverseJoinColumns = @JoinColumn(name = "subscribed_person"))
    private List<Person> listeningPeople;
}
