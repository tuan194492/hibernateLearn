package com.example.learnhibernate;

import com.example.learnhibernate.dao.HibernateLopDAO;
import com.example.learnhibernate.dao.LopDAO;
import com.example.learnhibernate.model.Lop;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "bean")
@SessionScoped
public class Bean implements Serializable {

    private String message = "Hello world from Tuan";

    public String getMessage() {
        return message;
    }
    public String testDB2() {
        LopDAO lopDAO = new HibernateLopDAO();
        System.out.println("Hello world outside begin");
//        Lop lopDemo = new Lop();
//        lopDemo.setName("12A3");
//        lopDAO.themLop(lopDemo);
        List<Lop> lopList = lopDAO.getAllLop();

        System.out.println("Lop size: " + lopList.size());

        System.out.println("Hello world inside");
        for (Lop lop : lopList) {
            System.out.println(lop.getName());
        }

        System.out.println("Hello world outside end");

        return "Hello world";
    }

    public void addLop() {
        LopDAO lopDAO = new HibernateLopDAO();
        Lop lopDemo = new Lop();
        lopDemo.setName("12A3");
        lopDAO.themLop(lopDemo);
    }
}
