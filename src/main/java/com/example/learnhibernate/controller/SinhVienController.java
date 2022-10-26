package com.example.learnhibernate.controller;


import com.example.learnhibernate.dao.HibernateSinhVienDAO;
import com.example.learnhibernate.dao.JPASinhVienDAO;
import com.example.learnhibernate.dao.SinhVienDAO;
import com.example.learnhibernate.model.Lop;
import com.example.learnhibernate.model.SinhVien;
import com.example.learnhibernate.util.HibernateUtils;
import com.example.learnhibernate.util.JPAUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@Named(value = "sinhVienController")
@ConversationScoped
public class SinhVienController  implements Serializable {
    public SinhVienController() {
        sinhVienDAO = new JPASinhVienDAO();
    }
    private final SinhVienDAO sinhVienDAO;
    private List<SinhVien> sinhVienList;
    private SinhVien selectedSinhVien;

    public void setSinhVienList(List<SinhVien> sinhVienList) {
        this.sinhVienList = sinhVienList;
    }

    public void selectSinhVien(int id) {
        selectedSinhVien = sinhVienDAO.getSinhVienById(id);
    }

    public void setSelectedSinhVien(SinhVien selectedSinhVien) {
        this.selectedSinhVien = selectedSinhVien;
    }

    public List<SinhVien> getSinhVienList() {
//        System.out.println("Hello world from Tuan");
        sinhVienList = sinhVienDAO.getAllSinhVien();
        return sinhVienList;
    }

    public SinhVien getSelectedSinhVien() {
        return selectedSinhVien;
    }

    public String goToEditPage(SinhVien sinhVien) {
//        System.out.println(sinhVien.getId());
        if (sinhVien == null) {
            selectedSinhVien = null;
        } else {
            selectSinhVien(sinhVien.getId());
        }
        return "edit";
    }

    public String saveSinhVien(SinhVien sinhVien) {
        if (sinhVien.getId() <= 0) {
            sinhVienDAO.themSinhVien(sinhVien);
        } else {
            sinhVienDAO.updateSinhVien(sinhVien);
        }
        return "index";
    }

    public String createSinhVien() {
        selectedSinhVien = new SinhVien();
        selectedSinhVien.setId(-1);
        return "edit";
    }
    public String createSinhVien(Lop lop) {
        selectedSinhVien = new SinhVien();
        selectedSinhVien.setId(-1);
        selectedSinhVien.setLop(lop);
        return "edit";
    }

    public void deleteSinhVien(SinhVien sinhVien) {
        System.out.println("Delete sinh vien");
        sinhVienDAO.xoaSinhVien(sinhVien);
    }

    public List<SinhVien> getSinhVienFromLop(Lop lop) {
        if (lop != null) {
//            lop = HibernateUtils.getSession().get(Lop.class, lop.getId());
            EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
            lop = entityManager.find(Lop.class, lop.getId());
            entityManager.close();
            return lop.getSinhVienList();
        }
        else
            return null;
    }

    @PostConstruct
    public void init() {
        System.out.println("Sinh Vien controller is created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Sinh Vien controller destroyed");
    }

}

