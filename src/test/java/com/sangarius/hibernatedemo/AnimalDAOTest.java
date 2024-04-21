package com.sangarius.hibernatedemo;

import com.sangarius.hibernatedemo.dao.AnimalDAO;
import com.sangarius.hibernatedemo.data.DataGenerator;
import com.sangarius.hibernatedemo.entity.Animal;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AnimalDAOTest {

    private static EntityManagerFactory emf;
    private AnimalDAO animalDAO;

    @BeforeAll
    static void setUpAll() {
        emf = Persistence.createEntityManagerFactory("ZooPersistenceUnit");
    }

    @BeforeEach
    void setUp() {
        animalDAO = new AnimalDAO(emf);
    }

    @AfterEach
    void tearDown() {
        emf.getCache().evictAll();
    }

    @AfterAll
    static void tearDownAll() {
        emf.close();
    }

    @Test
    void testAdd() {
        Animal animal = DataGenerator.generateAnimal();
        assertDoesNotThrow(() -> animalDAO.add(animal));
    }

    @Test
    void testSave() {
        Animal animal = DataGenerator.generateAnimal();
        assertDoesNotThrow(() -> animalDAO.save(animal));
    }

    @Test
    void testGetById() {
        Animal animal = DataGenerator.generateAnimal();
        animalDAO.add(animal);
        Animal retrievedAnimal = animalDAO.getById(animal.getId());
        assertNotNull(retrievedAnimal);
        assertEquals(animal.getName(), retrievedAnimal.getName());
    }

    @Test
    void testGetAll() {
        List<Animal> animals = animalDAO.getAll();
        assertNotNull(animals);
        assertFalse(animals.isEmpty());
    }

    @Test
    void testGetByName() {
        Animal animal = DataGenerator.generateAnimal();
        animalDAO.add(animal);
        Animal retrievedAnimal = animalDAO.getByName(animal.getName(), "name");
        assertNotNull(retrievedAnimal);
        assertEquals(animal.getName(), retrievedAnimal.getName());
    }

    @Test
    void testUpdate() {
        Animal animal = DataGenerator.generateAnimal();
        animalDAO.add(animal);
        animal.setAge(100);
        assertDoesNotThrow(() -> animalDAO.update(animal));
        Animal updatedAnimal = animalDAO.getById(animal.getId());
        assertNotNull(updatedAnimal);
        assertEquals(100, updatedAnimal.getAge());
    }

    @Test
    void testDelete() {
        Animal animal = DataGenerator.generateAnimal();
        animalDAO.add(animal);
        assertDoesNotThrow(() -> animalDAO.delete(animal.getId()));
        assertNull(animalDAO.getById(animal.getId()));
    }
}