package com.J3M.nwhacks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "person")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @JoinColumns(@JoinColumn(name = "currentLocationId", referencedColumnName = "id"))
    private Location currentLocation;

    @ManyToMany
    @JoinTable(name = "subscribedLocations")
    private Set<Location> subscribedLocations;

    @ManyToMany
    @JoinTable(
            name = "subscribedPersons",
            joinColumns = @JoinColumn(name = "subscribed_person"),
            inverseJoinColumns = @JoinColumn(name = "listening_person"))
    private Set<Person> subscribedPeople;

    @ManyToMany
    @JoinTable(
            name = "subscribedPersons",
            joinColumns = @JoinColumn(name = "listening_person"),
            inverseJoinColumns = @JoinColumn(name = "subscribed_person"))
    private Set<Person> listeningPeople;
}
