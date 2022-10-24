package com.example.learnhibernate.dao;


import com.example.learnhibernate.model.Lop;
import java.util.List;

public interface LopDAO {
    List<Lop> getAllLop();
    void themLop(Lop lop);
    void xoaLop(Lop lop);
    Lop getLopById(int id);
    void updateLop(Lop lop);
}
