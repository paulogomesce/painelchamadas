package br.com.painel.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesMessageUtil {
	
	public static void addMessage(String messagem){
		FacesMessage facesMessage = new FacesMessage(messagem, messagem);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
	
	public static void addWarn(String messagem){
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, messagem, messagem);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
	
	public static void addErro(String messagem){
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, messagem, messagem);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

}