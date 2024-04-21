package com.sangarius.hibernatedemo.dao;

import com.sangarius.hibernatedemo.dao.generic.GenericDAOImpl;
import com.sangarius.hibernatedemo.entity.Employee;
import jakarta.persistence.EntityManagerFactory;

public class EmployeeDAO extends GenericDAOImpl<Employee> {

    public EmployeeDAO(EntityManagerFactory emf) {
        super(emf, Employee.class);
    }
}