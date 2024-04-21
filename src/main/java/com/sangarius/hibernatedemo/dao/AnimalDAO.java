package com.sangarius.hibernatedemo.dao;

import com.sangarius.hibernatedemo.entity.Animal;
import com.sangarius.hibernatedemo.dao.generic.GenericDAOImpl;
import jakarta.persistence.EntityManagerFactory;

public class AnimalDAO extends GenericDAOImpl<Animal> {

    public AnimalDAO(EntityManagerFactory emf) {
        super(emf, Animal.class);
    }
}