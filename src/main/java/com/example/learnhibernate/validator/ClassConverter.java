package com.example.learnhibernate.validator;

import com.example.learnhibernate.dao.HibernateLopDAO;
import com.example.learnhibernate.dao.LopDAO;
import com.example.learnhibernate.model.Lop;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.criteria.CriteriaBuilder;

@FacesConverter(value = "classConverter")
public class ClassConverter implements Converter {
    private final LopDAO lopDAO = new HibernateLopDAO();
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        int id = Integer.parseInt(s);
        Lop lop = lopDAO.getLopById(id);
        if (lop != null) {
            return lop;
        } else {
            throw new ConverterException(new FacesMessage("Khong ton tai lop"));
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Lop lop = (Lop) o;
        return String.valueOf(lop.getId());
    }
}
