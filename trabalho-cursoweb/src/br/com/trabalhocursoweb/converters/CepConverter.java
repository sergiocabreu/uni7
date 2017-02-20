package br.com.trabalhocursoweb.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.trabalhocursoweb.business.CepInvalidoException;
import br.com.trabalhocursoweb.model.Cep;

@FacesConverter("converters.CepConverter")
public class CepConverter implements Converter {
	
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        
    	if (value != null && !value.isEmpty()) {
            
    		try {
    		
    			if (!value.contains("-")) throw new CepInvalidoException("CEP invalido. Padrao 00000-000.");
    		
    			String[] cep = value.split("-");
    			
    			Cep cepObject = new Cep();
    			cepObject.setRegiao(cep[0]);
    			cepObject.setSufixo(cep[1]);
            
    			return cepObject;
    			
            } catch (Exception e) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro de conversão", e.getMessage());
                throw new ConverterException(message);
            }
        }
        return null;
    }
    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        
    	String cepString = "";
        
    	if (value != null) {
    		Cep cep = (Cep) value;
    	
            cepString = cep.getRegiao() +"-" + cep.getSufixo();
        }
    	
        return cepString;
    }

}