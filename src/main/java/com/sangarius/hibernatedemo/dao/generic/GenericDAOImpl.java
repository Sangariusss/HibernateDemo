package com.sangarius.hibernatedemo.dao.generic;

import com.sangarius.hibernatedemo.dao.exceptions.DAOException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;

public class GenericDAOImpl<T> implements GenericDAO<T> {

    private final EntityManagerFactory emf;
    private final Class<T> entityType;

    public GenericDAOImpl(EntityManagerFactory emf, Class<T> entityType) {
        this.emf = emf;
        this.entityType = entityType;
    }

    @Override
    public void add(T entity) {
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.merge(entity);
            tx.commit();
        } catch (RuntimeException e) {
            throw new DAOException("Error adding entity", e);
        }
    }

    @Override
    public void save(T entity) {
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.merge(entity);
            tx.commit();
        } catch (RuntimeException e) {
            throw new DAOException("Error saving entity", e);
        }
    }

    @Override
    public T getById(UUID id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(entityType, id);
        } catch (RuntimeException e) {
            throw new DAOException("Error getting entity by id", e);
        }
    }

    @Override
    public List<T> getAll() {
        try (EntityManager em = emf.createEntityManager()) {
            CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(entityType);
            criteriaQuery.from(entityType);
            return em.createQuery(criteriaQuery).getResultList();
        } catch (RuntimeException e) {
            throw new DAOException("Error getting all entities", e);
        }
    }

    @Override
    public T getByName(String name, String columnName) {
        try (EntityManager em = emf.createEntityManager()) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityType);
            Root<T> root = cq.from(entityType);
            cq.select(root).where(cb.equal(root.get(columnName), name));
            return em.createQuery(cq).getResultList().stream().findFirst().orElse(null);
        } catch (RuntimeException e) {
            throw new DAOException("Error getting entity by name", e);
        }
    }

    @Override
    public void update(T entity) {
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.merge(entity);
            tx.commit();
        } catch (RuntimeException e) {
            throw new DAOException("Error updating entity", e);
        }
    }

    @Override
    public void delete(UUID id) {
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            T entity = em.find(entityType, id);
            if (entity != null) {
                em.remove(entity);
            }
            tx.commit();
        } catch (RuntimeException e) {
            throw new DAOException("Error deleting entity", e);
        }
    }
}