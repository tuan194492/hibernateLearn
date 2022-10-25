package com.example.learnhibernate.controller;

import com.example.learnhibernate.dao.HibernateLopDAO;
import com.example.learnhibernate.dao.LopDAO;
import com.example.learnhibernate.model.Lop;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "lopController")
@ConversationScoped
public class LopController implements Serializable {

    private final LopDAO lopDAO;
    private List<Lop> lopList;
    private Lop selectedLop;

    public Lop getSelectedLop() {
        return selectedLop;
    }

    public void selectLop(Lop lop) {
        if (lop != null)
            selectedLop = lop;
        else
           selectedLop = null;
    }

    public LopController() {
        lopDAO = new HibernateLopDAO();
        selectedLop = null;
    }
    public List<Lop> getLopList() {
        lopList = lopDAO.getAllLop();
        return lopList;
    }

    public void deleteLop(Lop lop) {
        lopDAO.xoaLop(lop);
    }

    public void addLop(Lop lop) {
        lopDAO.themLop(lop);
    }

    public void updateLop(Lop lop) {
        if (lop != null)
            lopDAO.updateLop(lop);
    }

    public void createNewClass() {
        Lop lop = new Lop();
        lop.setName("Default name");
        lopDAO.themLop(lop);
    }

    public void unSelectLop() {
        selectedLop = null;
    }
    @PostConstruct
    public void init() {
        System.out.println("Lop controller is created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Lop controller destroyed");
    }
}
