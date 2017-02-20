package com.bolao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.bolao.dao.ParticipanteDAO;
import com.bolao.dao.ParticipanteDAOImpl;
import com.bolao.model.Participante;

@FacesConverter("ParticipanteConverter")
public class ParticipanteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {

		ParticipanteDAO participanteDAO = null;
		try {
			participanteDAO = new ParticipanteDAOImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return participanteDAO.findById(Long.parseLong(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		String id = "";
		
		if (arg2 != null && !arg2.equals("")) {
			Participante  participante = (Participante) arg2;
			if (participante != null && participante.getId() != null)
			id = participante.getId().toString();
		}
		
		return id;
	}

}
