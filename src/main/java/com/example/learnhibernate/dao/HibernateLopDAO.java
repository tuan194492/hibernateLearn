package com.example.learnhibernate.dao;

import com.example.learnhibernate.model.Lop;
import com.example.learnhibernate.util.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class HibernateLopDAO implements LopDAO{
    @Override
    public List<Lop> getAllLop() {
        Session session = HibernateUtils.getSession();
        return session.createQuery("from Lop", Lop.class).list();
    }

    @Override
    public void themLop(Lop lop) {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.save(lop);
        session.getTransaction().commit();
    }

    @Override
    public void xoaLop(Lop lop) {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.delete(lop);
        session.getTransaction().commit();
    }

    @Override
    public Lop getLopById(int id) {
        Session session = HibernateUtils.getSession();
        return session.get(Lop.class, id);
    }

    @Override
    public void updateLop(Lop lop) {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.save(lop);
        session.getTransaction().commit();
    }
}
