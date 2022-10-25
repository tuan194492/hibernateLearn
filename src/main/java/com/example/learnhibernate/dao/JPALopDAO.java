package com.example.learnhibernate.dao;

import com.example.learnhibernate.model.Lop;
import com.example.learnhibernate.util.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JPALopDAO implements LopDAO{
    private final EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
    @Override
    public List<Lop> getAllLop() {
        EntityManager entityManager = emf.createEntityManager();
        List<Lop> result = entityManager.createQuery("select lop from Lop lop", Lop.class).getResultList();
        entityManager.close();
        return result;
    }

    @Override
    public void themLop(Lop lop) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(lop);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void xoaLop(Lop lop) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Lop target = entityManager.find(Lop.class, lop.getId());
        entityManager.remove(target);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Lop getLopById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        Lop result = entityManager.find(Lop.class, id);
        entityManager.close();
        return result;
    }

    @Override
    public void updateLop(Lop lop) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(lop);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
