package com.example.learnhibernate.dao;

import com.example.learnhibernate.model.SinhVien;
import com.example.learnhibernate.util.HibernateUtils;
import com.sun.media.sound.SoftChannelProxy;
import org.hibernate.Session;

import java.util.List;

public class HibernateSinhVienDAO implements SinhVienDAO{
    @Override
    public List<SinhVien> getAllSinhVien() {
        Session session = HibernateUtils.getSession();
        return session.createQuery("from SinhVien", SinhVien.class).list();
    }

    @Override
    public SinhVien getSinhVienById(int id) {
        Session session = HibernateUtils.getSession();
        return session.get(SinhVien.class, id);
    }

    @Override
    public void themSinhVien(SinhVien sinhVien) {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.save(sinhVien);
        session.getTransaction().commit();
    }

    @Override
    public void xoaSinhVien(SinhVien sinhVien) {
        Session session = HibernateUtils.getSession();
        SinhVien target = session.get(SinhVien.class, sinhVien.getId());
        session.beginTransaction();
        session.delete(target);
        session.getTransaction().commit();
    }

    @Override
    public void updateSinhVien(SinhVien sinhVien) {
        Session session = HibernateUtils.getSession();
        SinhVien target = session.get(SinhVien.class, sinhVien.getId());
        session.beginTransaction();
        target.setName(sinhVien.getName());
        target.setBirth(sinhVien.getBirth());
        target.setLop(sinhVien.getLop());
        session.save(target);
        session.getTransaction().commit();
    }

}
