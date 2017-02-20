package br.com.trabalhocursoweb.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.trabalhocursoweb.business.UsuarioBusiness;
import br.com.trabalhocursoweb.business.UsuarioInvalidoException;
import br.com.trabalhocursoweb.model.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {

	/** Referencia para a camada de regras de negocio */
	@ManagedProperty("#{usuarioBusiness}")
	private UsuarioBusiness usuarioBusiness;

	/** Usuario autenticado na aplicacao */
	private Usuario usuarioAutenticado;

	private String cpf;

	private String senha;

	public void setUsuarioBusiness(UsuarioBusiness usuarioBusiness) {
		this.usuarioBusiness = usuarioBusiness;
	}

	public Usuario getUsuarioAutenticado() {
		return usuarioAutenticado;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String autenticar() {
		try {
			usuarioAutenticado = usuarioBusiness.autenticarUsuario(cpf, senha);
			return "index?faces-redirect=true";
		} catch (UsuarioInvalidoException e) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setDetail("Usuário ou senha inválidos!");
			FacesContext.getCurrentInstance().addMessage("loginForm", message);
			return null;
		} finally {
			cpf = null;
			senha = null;
		}
	}
}