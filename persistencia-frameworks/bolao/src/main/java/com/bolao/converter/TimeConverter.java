package com.bolao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.bolao.dao.TimeDAO;
import com.bolao.dao.TimeDAOImpl;
import com.bolao.model.Time;

@FacesConverter("TimeConverter")
public class TimeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		TimeDAO timeDAO = null;
		try {
			timeDAO = new TimeDAOImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return timeDAO.buscar(Long.parseLong(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		String id = "";
		
		if (arg2 != null && !arg2.equals("")) {
			Time time = (Time) arg2;
			if(time != null && time.getId() != null)
				id = time.getId().toString();
		}
		return id;
	}

}
