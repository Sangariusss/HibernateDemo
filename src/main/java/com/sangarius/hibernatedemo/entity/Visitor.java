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
public class Visitor {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private int age;
}