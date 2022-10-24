package com.example.learnhibernate.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;


/**
 * Date pattern available:
 * dd-mm-yyyy
 * dd/mm/yyyy
 * ddmmyyyy
 */
@FacesValidator(value = "dateValidator")
public class DateValidator implements Validator {
    final String[] dateFormatList = {
            "dd-MM-yyyy",
            "dd/MM/yyyy",
            "ddMMyyyy"
    };
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        Date date = (Date) o;
        try {
            LocalDate localDate = convertToLocalDate(date);
            LocalDate curDate = convertToLocalDate(Calendar.getInstance().getTime());
            int age = getAge(localDate, curDate);
            if (age <= 18)
                throw  new ValidatorException(new FacesMessage("Invalid birth"));
        } catch (Exception e) {
            throw  new ValidatorException(new FacesMessage("Invalid birth"));
        }

    }

    public int getAge(LocalDate date1, LocalDate date2) {
        return Period.between(date1, date2).getYears();
    }

    public LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
