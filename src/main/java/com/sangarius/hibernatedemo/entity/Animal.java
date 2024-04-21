package com.sangarius.hibernatedemo.entity;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
public class Animal {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String species;
    private int age;
    private UUID enclosureId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enclosure_id")
    private Enclosure enclosure;

    public Animal() {
        this.id = UUID.randomUUID();
    }

    public Animal(UUID id, String name, String species, int age) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
    }
}