package com.bolao.business;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.bolao.dao.ParticipanteDAO;
import com.bolao.dao.ParticipanteDAOImpl;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;*/

import com.bolao.model.Participante;
import com.bolao.util.FacesUtil;

public class AuthenticationBusiness {

	private ParticipanteDAO participanteDAO;

	public AuthenticationBusiness() {
		try {
			participanteDAO = new ParticipanteDAOImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String login(String username, String password) {
		try {

			Participante usuario1 = (Participante) participanteDAO.findByUsername(username);
			// verificando se o usuario esta ativo
			if (!usuario1.isEnabled()) {
				return "inativo";
			}

			// criptografia MD5
			password = toMd5(password);

			// pergando o usuario
			//Participante usuario = (Participante) getUsuarioLogado();

			// verificando se o usuario esta ativo
			/*if (!usuario1.isEnabled()) {
				return "Usuário nao esta ativo!";
			}*/

			// Verificando se a senha esta expirada
			if (!usuario1.isAccountNonExpired()) {
				return "Senha expirada!";
			}

			// verificando se o usuario tem alguma permissao
			// if (usuario.getAuthorities().size() == 0) {
			// return "Usuário nÃ£o tem permissão de acesso";
			// }

			// verificando autenticacao
			if (usuario1.getPassword().equals(password)) {
				FacesUtil.setSessionAttribute("usuarioLogado", usuario1);
				return "ok";
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return "Login ou senha inválidos";
	}

	public void logout() {
		invalidateSession();
	}

	public Participante getUsuarioLogado() {
		return (Participante) FacesUtil.getSessionAttribute("usuarioLogado");
	}

	private void invalidateSession() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.invalidate();
	}

	/**
	 * Encripta valores com hash md5
	 * 
	 * @param String
	 *            valor
	 * 
	 * @return String md5
	 */
	private static String toMd5(String valor) {
		String md5 = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			BigInteger hashForm = new BigInteger(1, md.digest(valor.getBytes()));
			md5 = hashForm.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}

	public static void main(String[] args) {
		System.out.println(toMd5("1"));
	}
}
