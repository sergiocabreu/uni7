package com.bolao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.bolao.dao.GrupoDAO;
import com.bolao.dao.GrupoDAOImpl;
import com.bolao.model.Grupo;

@FacesConverter("GrupoConverter")
public class GrupoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {

		GrupoDAO grupoDAO = null;
		try {
			grupoDAO = new GrupoDAOImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return grupoDAO.buscar(Long.parseLong(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		String id = "";
		
		if (arg2 != null && !arg2.equals("")) {
			Grupo grupo = (Grupo) arg2;
			if (grupo != null && grupo.getId() != null)
			id = grupo.getId().toString();
		}
		
		return id;
	}

}
