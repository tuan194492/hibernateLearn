package com.example.learnhibernate.validator;

import com.example.learnhibernate.dao.HibernateLopDAO;
import com.example.learnhibernate.dao.LopDAO;
import com.example.learnhibernate.model.Lop;
import com.example.learnhibernate.model.SinhVien;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "studentValidator")
public class StudentValidator implements Validator {
    private final LopDAO lopDAO = new HibernateLopDAO();
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        try {
            System.out.println(o.toString());
            Lop lop = (Lop) o;
            if (lopDAO.getLopById(lop.getId()) == null) {
                throw new ValidatorException(new FacesMessage("K ton tai Id lop nay"));
            }

        } catch (Exception e) {
            throw new ValidatorException(new FacesMessage("K ton tai Id lop nay"));
        }
    }
}
