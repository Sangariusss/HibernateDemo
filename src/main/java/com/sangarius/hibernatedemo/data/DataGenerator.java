package com.sangarius.hibernatedemo.data;

import com.github.javafaker.Faker;
import com.sangarius.hibernatedemo.entity.Animal;
import com.sangarius.hibernatedemo.entity.Employee;
import com.sangarius.hibernatedemo.entity.Enclosure;
import com.sangarius.hibernatedemo.entity.Visitor;
import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    private static final Faker faker = new Faker();

    private DataGenerator() {

    }

    public static Animal generateAnimal() {
        Animal animal = new Animal();
        animal.setName(faker.name().firstName());
        animal.setSpecies(faker.animal().name());
        animal.setAge(faker.number().numberBetween(1, 20));
        return animal;
    }

    public static List<Animal> generateAnimals(int count) {
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            animals.add(generateAnimal());
        }
        return animals;
    }

    public static Employee generateEmployee() {
        Employee employee = new Employee();
        employee.setName(faker.name().fullName());
        employee.setType(faker.job().position());
        employee.setCapacity(faker.number().numberBetween(1, 10));
        return employee;
    }

    public static List<Employee> generateEmployees(int count) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            employees.add(generateEmployee());
        }
        return employees;
    }

    public static Enclosure generateEnclosure() {
        Enclosure enclosure = new Enclosure();
        enclosure.setName(faker.address().buildingNumber());
        enclosure.setPosition(faker.address().streetAddress());
        enclosure.setSalary(faker.number().randomDouble(2, 1000, 5000));
        return enclosure;
    }

    public static List<Enclosure> generateEnclosures(int count) {
        List<Enclosure> enclosures = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            enclosures.add(generateEnclosure());
        }
        return enclosures;
    }

    public static Visitor generateVisitor() {
        Visitor visitor = new Visitor();
        visitor.setName(faker.name().fullName());
        visitor.setAge(faker.number().numberBetween(5, 100));
        return visitor;
    }

    public static List<Visitor> generateVisitors(int count) {
        List<Visitor> visitors = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            visitors.add(generateVisitor());
        }
        return visitors;
    }
}