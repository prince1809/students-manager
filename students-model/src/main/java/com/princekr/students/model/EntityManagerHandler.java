package com.princekr.students.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by prince on 10/10/16.
 */
public enum  EntityManagerHandler {

    INSTANCE;

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("students-persistence-unit");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();

    public void open() {
        if (!entityTransaction.isActive()) {
            entityTransaction.begin();
        }
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public EntityTransaction getEntityTransaction() {
        return entityTransaction;
    }

    public void shutdown() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
