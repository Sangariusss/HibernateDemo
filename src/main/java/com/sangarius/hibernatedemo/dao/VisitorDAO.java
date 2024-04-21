package com.sangarius.hibernatedemo.dao;

import com.sangarius.hibernatedemo.dao.generic.GenericDAOImpl;
import com.sangarius.hibernatedemo.entity.Visitor;
import jakarta.persistence.EntityManagerFactory;

public class VisitorDAO extends GenericDAOImpl<Visitor> {

    public VisitorDAO(EntityManagerFactory emf) {
        super(emf, Visitor.class);
    }
}