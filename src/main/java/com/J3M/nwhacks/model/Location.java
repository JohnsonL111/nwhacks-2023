package com.J3M.nwhacks.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "location")
@Data
public class Location {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
