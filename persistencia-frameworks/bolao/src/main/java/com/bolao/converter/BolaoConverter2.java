package com.bolao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.bolao.dao.BolaoDAO;
import com.bolao.dao.BolaoDAOImpl;
import com.bolao.model.Bolao;

@FacesConverter("BolaoConverter")
public class BolaoConverter2 implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {

		BolaoDAO bolaoDAO = null;
		try {
			bolaoDAO = new BolaoDAOImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bolaoDAO.buscar(Long.parseLong(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		String id = "";
		
		if (arg2 != null && !arg2.equals("")) {
			Bolao bolao = (Bolao) arg2;
			if (bolao != null && bolao.getId() != null)
			id = bolao.getId().toString();
		}
		
		return id;
	}

}
