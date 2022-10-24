package com.example.learnhibernate.dao;

import com.example.learnhibernate.model.SinhVien;

import java.util.List;

public interface SinhVienDAO {
    List<SinhVien> getAllSinhVien();
    SinhVien getSinhVienById(int id);
    void themSinhVien(SinhVien sinhVien);
    void xoaSinhVien(SinhVien sinhVien);
    void updateSinhVien(SinhVien sinhVien);

}
