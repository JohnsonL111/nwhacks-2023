package com.J3M.nwhacks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import liquibase.repackaged.org.apache.commons.lang3.builder.HashCodeExclude;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
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
    @JsonIgnore
    @HashCodeExclude
    private Location currentLocation;

    @ManyToMany
    @JoinTable(name = "subscribedLocations")
    @JsonIgnore
    @HashCodeExclude
    private List<Location> subscribedLocations;

    @ManyToMany
    @JoinTable(
            name = "subscribedPersons",
            joinColumns = @JoinColumn(name = "subscribed_person"),
            inverseJoinColumns = @JoinColumn(name = "listening_person"))
    @JsonIgnore
    @ToString.Exclude
    @HashCodeExclude
    private List<Person> subscribedPeople;

    @ManyToMany
    @JoinTable(
            name = "subscribedPersons",
            joinColumns = @JoinColumn(name = "listening_person"),
            inverseJoinColumns = @JoinColumn(name = "subscribed_person"))
    @JsonIgnore
    @ToString.Exclude
    @HashCodeExclude
    private List<Person> listeningPeople;
}
