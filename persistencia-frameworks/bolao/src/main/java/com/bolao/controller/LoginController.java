package com.bolao.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

import com.bolao.business.AuthenticationBusiness;
import com.bolao.model.Participante;
import com.bolao.util.FacesUtil;

@SuppressWarnings("serial")
@ManagedBean
@RequestScoped
public class LoginController implements Serializable {

	private AuthenticationBusiness authenticationBusiness;

	private String login;
	private String senha;

	private String mensagem = new String();

	@PostConstruct
	public void init() {
		authenticationBusiness = new AuthenticationBusiness();
	}

	public String autenticar() {

		this.mensagem = new String();
		String mensagemLogin = new String();

		try {

			mensagemLogin = authenticationBusiness.login(login, senha);

		} catch (Exception e) {
			this.mensagem = "Erro de conexão interna do sistema.";
			FacesUtil.addErroMessage("Erro de conexãoo£o interno do sistema. OperaÃ§Ã£o cancelada.");
			return "login";
		}

		if (!mensagemLogin.equalsIgnoreCase("ok")) {
			this.login = new String();
			this.senha = new String();
			this.mensagem = mensagemLogin;
			if (mensagemLogin.equalsIgnoreCase("inativo"))
				RequestContext.getCurrentInstance().execute("dlg.show()");
			return "login";
		}

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();

		// Setando atributo logado como true para posterior identificaï¿½ï¿½o
		request.getSession().setAttribute("logado", true);

		// Setando o nome do usuï¿½rio na sessï¿½o
		request.getSession().setAttribute("usuario", login);

		return "paginas/inicio?faces-redirect=true";
	}

	public String logout() {
		authenticationBusiness.logout();
		return "login";
	}

	public Participante getUsuarioLogado() {

		try {

			return authenticationBusiness.getUsuarioLogado();

		} catch (Exception e) {
			FacesUtil.addErroMessage("Erro na identificaÃ§Ã£o do usuario logado. Favor efetuar novo login.");
		}

		return null;
	}

	/*
	 * public boolean anyGranted(String value) {
	 * 
	 * // pegando a lista de grants passado String[] listaGrants =
	 * value.split(",");
	 * 
	 * for (GrantedAuthority permissao : authenticationService
	 * .getUsuarioLogado().getAuthorities()) {
	 * 
	 * for (String grant : listaGrants) { if
	 * (permissao.getAuthority().equals(grant)) return true; }
	 * 
	 * }
	 * 
	 * return false; }
	 */

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
