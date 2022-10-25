package com.example.learnhibernate.validator;

import com.example.learnhibernate.dao.HibernateSinhVienDAO;
import com.example.learnhibernate.dao.SinhVienDAO;
import com.example.learnhibernate.model.Lop;
import com.example.learnhibernate.model.SinhVien;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "studentConverter")
public class StudentConverter implements Converter {
    private final SinhVienDAO sinhVienDAO = new HibernateSinhVienDAO();

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        int id = Integer.parseInt(s);
        SinhVien sinhVien = sinhVienDAO.getSinhVienById(id);
        if (sinhVien != null) {
            return sinhVien;
        } else {
            throw new ConverterException(new FacesMessage("Khong ton tai Sinh vien"));
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        SinhVien sinhVien = (SinhVien) o;
        return String.valueOf(sinhVien.getId());
    }
}
