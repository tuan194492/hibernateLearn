package com.example.learnhibernate.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
@FacesValidator(value = "nameValidator")
public class NameValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String input = o.toString();
        if (!containsOnlyWords(input)) {
            FacesMessage msg = new FacesMessage("Name pattern error", "Name can only contain words");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

    public boolean containsOnlyWords(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!isAlphabet(input.charAt(i)))
                return false;
        }
        return true;
    }
    public boolean isAlphabet(char input) {
        return (input >= 'a' && input <= 'z') || (input >= 'A' && input <= 'Z') || input == ' ';
    }
}
