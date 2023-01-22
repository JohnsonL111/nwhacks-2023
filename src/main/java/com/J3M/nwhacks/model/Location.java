package com.J3M.nwhacks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import liquibase.repackaged.org.apache.commons.lang3.builder.HashCodeExclude;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

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
    @JsonIgnore
    @ToString.Exclude
    @HashCodeExclude
    private List<Person> currentPeople;

    @ManyToMany
    @JoinTable(name = "subscribedLocations")
    @JsonIgnore
    @ToString.Exclude
    @HashCodeExclude
    private List<Person> listeningPeople;
}
