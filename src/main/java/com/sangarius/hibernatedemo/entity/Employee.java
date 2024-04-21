package com.sangarius.hibernatedemo.entity;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String type;
    private int capacity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "enclosure_id")
    private Enclosure enclosure;

    public Employee(UUID id, String name, String type, int capacity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }
}