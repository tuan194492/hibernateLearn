package com.example.learnhibernate.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "class")
public class Lop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "loptruong_id", referencedColumnName = "student_id")
    private SinhVien lopTruong;

    @OneToMany(mappedBy = "lop")
    private List<SinhVien> sinhVienList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SinhVien getLopTruong() {
        return lopTruong;
    }

    public void setLopTruong(SinhVien lopTruong) {
        this.lopTruong = lopTruong;
    }

    public List<SinhVien> getSinhVienList() {
        return sinhVienList;
    }

    public void setSinhVienList(List<SinhVien> sinhVienList) {
        this.sinhVienList = sinhVienList;
    }
}
