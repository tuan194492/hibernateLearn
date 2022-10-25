package com.example.learnhibernate.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "nameConverter")
public class NameConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        String[] stringList = s.split(" ");
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < stringList.length; i ++) {
            if (stringList[i].length() >= 2)
                stringList[i] = stringList[i].substring(0, 1).toUpperCase() + stringList[i].substring(1);
            else {
                if (stringList[i].length() > 1)
                    stringList[i] = stringList[i].substring(0, 1).toUpperCase();
                else
                    stringList[i] = stringList[i].toUpperCase();
            }
            result.append(stringList[i]);
            result.append(" ");
        }
        return result.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {

        String[] stringList = o.toString().split(" ");
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < stringList.length; i ++) {
            if (stringList[i].length() > 1)
                stringList[i] = stringList[i].substring(0, 1).toUpperCase() + stringList[i].substring(1);
            else
                stringList[i] = stringList[i].toUpperCase();
            result.append(stringList[i]);
            result.append(" ");
        }
        return result.toString();
    }
}
