package com.sangarius.hibernatedemo.dao;

import com.sangarius.hibernatedemo.dao.generic.GenericDAOImpl;
import com.sangarius.hibernatedemo.entity.Enclosure;
import jakarta.persistence.EntityManagerFactory;

public class EnclosureDAO extends GenericDAOImpl<Enclosure> {

    public EnclosureDAO(EntityManagerFactory emf) {
        super(emf, Enclosure.class);
    }
}