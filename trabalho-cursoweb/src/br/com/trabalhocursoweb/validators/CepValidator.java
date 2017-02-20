package br.com.trabalhocursoweb.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.trabalhocursoweb.model.Cep;
import br.com.trabalhocursoweb.util.ValidacaoHelper;

@FacesValidator("validators.CepValidator")
public class CepValidator implements Validator {
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
    	if (value != null) {
            Cep cep = (Cep) value;
            
            if (!ValidacaoHelper.validaCep(cep)) {
                FacesMessage message = new FacesMessage();
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                message.setSummary("Erro de Valida��o");
                message.setDetail("Cep Inv�lido");
                throw new ValidatorException(message);
            }
        }
    }
}