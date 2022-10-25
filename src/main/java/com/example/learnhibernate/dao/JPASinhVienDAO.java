package com.example.learnhibernate.dao;

import com.example.learnhibernate.model.Lop;
import com.example.learnhibernate.model.SinhVien;
import com.example.learnhibernate.util.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JPASinhVienDAO implements SinhVienDAO{

    private final EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
    @Override
    public List<SinhVien> getAllSinhVien() {
        EntityManager entityManager = emf.createEntityManager();
        List<SinhVien> result = entityManager.createQuery("select sinhvien from SinhVien sinhvien", SinhVien.class).getResultList();
        entityManager.close();
        return result;
    }

    @Override
    public SinhVien getSinhVienById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        SinhVien result = entityManager.find(SinhVien.class, id);
        entityManager.close();
        return result;
    }

    @Override
    public void themSinhVien(SinhVien sinhVien) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        sinhVien.setId(0);
        entityManager.persist(sinhVien);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void xoaSinhVien(SinhVien sinhVien) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        SinhVien target = entityManager.find(SinhVien.class, sinhVien.getId());
        entityManager.remove(target);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateSinhVien(SinhVien sinhVien) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
       entityManager.merge(sinhVien);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
