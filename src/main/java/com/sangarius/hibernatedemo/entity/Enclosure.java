package com.sangarius.hibernatedemo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Enclosure {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String position;
    private double salary;
    @OneToMany(mappedBy = "enclosure", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();
    @ManyToMany
    @JoinTable(
        name = "enclosure_visitor",
        joinColumns = @JoinColumn(name = "enclosure_id"),
        inverseJoinColumns = @JoinColumn(name = "visitor_id")
    )
    private List<Visitor> visitors = new ArrayList<>();

    public Enclosure(UUID id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}