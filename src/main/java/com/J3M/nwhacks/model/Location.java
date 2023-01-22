package com.J3M.nwhacks.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "location")
@Data
public class Location {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "currentLocation")
    private Set<Person> currentPeople;

    @ManyToMany
    @JoinTable(name = "subscribedLocations")
    private Set<Person> listeningPeople;
}
