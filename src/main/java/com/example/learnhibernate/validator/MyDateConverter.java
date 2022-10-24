package com.example.learnhibernate.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
@FacesConverter(value = "myDateConverter")
public class MyDateConverter implements Converter {
    final String[] dateFormatList = {
            "dd-MM-yyyy",
            "dd/MM/yyyy",
            "ddMMyyyy"
    };
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        System.out.println(s);
        try {
            DateFormat dateFormat;
            if (s.contains("-")) {
                dateFormat = new SimpleDateFormat(dateFormatList[0]);
            } else if (s.contains("/")) {
                dateFormat = new SimpleDateFormat(dateFormatList[1]);
            } else {
                dateFormat = new SimpleDateFormat(dateFormatList[2]);
            }
            return (Date) dateFormat.parse(s);
        } catch (Exception e) {
            throw new ConverterException(new FacesMessage("Invalid date"));
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String input = o.toString();
        try {
            DateFormat dateFormat;
            dateFormat = new SimpleDateFormat(dateFormatList[0]);
//            if (input.contains("-")) {
//                dateFormat = new SimpleDateFormat(dateFormatList[0]);
//            } else if (input.contains("/")) {
//                dateFormat = new SimpleDateFormat(dateFormatList[1]);
//            } else {
//                dateFormat = new SimpleDateFormat(dateFormatList[2]);
//            }
            return dateFormat.format((Date) o);
//            o = date.getDate() + "-" + date.getMonth() + "-" + date.getYear();
//            System.out.println(dateFormat.parse(input));
//            return o.toString();
        } catch (Exception e) {
            throw  new ConverterException(new FacesMessage("Invalid birth"));
        }
    }
}
