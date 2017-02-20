package com.bolao.util;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import static javax.faces.application.FacesMessage.SEVERITY_INFO;
import static javax.faces.context.FacesContext.getCurrentInstance;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class FacesUtil {

	public static FacesContext getFacesContext() {
		return getCurrentInstance();
	}

	public static ExternalContext getExternalContext() {
		return getCurrentInstance().getExternalContext();
	}

	public static Object getSessionAttribute(String attribute) {
		return getExternalContext().getSessionMap().get(attribute);
	}

	public static void setSessionAttribute(String name, Object value) {
		getExternalContext().getSessionMap().put(name, value);
	}

	public static Object getApplicationAttribute(String attribute) {
		return getExternalContext().getApplicationMap().get(attribute);
	}
	
	public static Application getApplication() {
		return getFacesContext().getApplication();
	}
	
	public static String getName() {
		return getExternalContext().getUserPrincipal().getName();
	}

	public static void addMessage(final String message) {
		getCurrentInstance().addMessage(null, new FacesMessage(message));
	}

	public static void addInfoMessage(String message) {
		getCurrentInstance().addMessage(null, new FacesMessage(SEVERITY_INFO, message, message));
	}
	
	public static void addInfoMessageWithouDetail(String message) {
		getCurrentInstance().addMessage(null, new FacesMessage(SEVERITY_INFO, message, ""));
	}
	
	public static void addInfoDetail(String detail) {
		getCurrentInstance().addMessage(null, new FacesMessage(SEVERITY_INFO, "", detail));
	}

	public static void addErroMessage(String message) {
		getCurrentInstance().addMessage(null, new FacesMessage(SEVERITY_ERROR, message, message));
	}
	
	public static void addErroMessageWithouDetail(String message) {
		getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, ""));
	}
	
	public static void addErroDetail(String detail) {
		getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", detail));
	}
	
	public static void addWarnMessageWithouDetail(String message) {
		getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, ""));
	}
	
	public static void addWarnDetail(String detail) {
		getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", detail));
	}

	public static String getTipoArquivo(String arquivo){
		int ponto = arquivo.lastIndexOf(".");
		return arquivo.substring(ponto);
	}

}

