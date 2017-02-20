package com.bolao.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;

import com.bolao.business.ParticipanteBusiness;
import com.bolao.business.ParticipanteBusinessImpl;
import com.bolao.exception.BolaoRuntimeException;
import com.bolao.model.Participante;
import com.bolao.util.BolaoUtil;
import com.bolao.util.FacesUtil;

@SuppressWarnings("serial")
@ManagedBean
@RequestScoped
public class ParticipanteFormController implements Serializable {

	private ParticipanteBusiness participanteBusiness;

	private BolaoUtil bolaoUtil;

	private Participante participante;

	private String password = new String();

	private String confirmarSenha = new String();

	private boolean alterar = false;

	private boolean ativacaoUsuario = false;

	private int contatoOpcao = 0;
	
	@PostConstruct
	public void init() {
		bolaoUtil = new BolaoUtil();
		participante = new Participante();
		participanteBusiness = new ParticipanteBusinessImpl();
	}

	// dados recuperar senha
	private String recuperarSenhaLogin = new String();
	private String recuperarSehnaEmail = new String();

	public String prepareCadastrar() {
		setParticipante(new Participante());
		return "cadastroForm";
	}

	public String prepareIncluir() {
		this.alterar = false;
		setParticipante(new Participante());
		return "participanteForm?faces-redirect=true";
	}

	public String prepareAlterar() {
		this.alterar = true;
		return "participanteForm";
	}

	private void limpar() {
		this.alterar = false;
		participante = new Participante();
	}

	public String limpaTela() {
		limpar();
		return "participanteForm";
	}

	public String salvar() {

		try {

			// verificar se o password foi alterado
			if (alterar == true && password.length() > 0) {
				// setando o novo password
				participante.setPassword(password);
			}

			// criptografando password e colocando para letra maiuscula
			if (alterar == false || password.length() > 0) {
				try {
					participante.setPassword(bolaoUtil.criptografarSenha(participante.getPassword()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// colocando em letra maiuscula para salvar
			participante.setNome(participante.getNome().toUpperCase());
			participante.setUsername(participante.getUsername().toUpperCase());

			/*System.out.println(
					participante.isAtivo() + " " + participanteBusiness.findByParticipante(participante).isAtivo());*/
			if (alterar && participante.isAtivo() && !participanteBusiness.findByParticipante(participante).isAtivo())
				ativacaoUsuario = true;

			participanteBusiness.salvar(participante);

			if (ativacaoUsuario) {
				StringBuilder msg = new StringBuilder();
				msg.append("Prezado(a) " + participante.getNome() + ",\n\n");
				msg.append("Seu pagamento foi efetuado com sucesso!\n");
				msg.append(
						"Você já pode cadastrar suas apostas na opção Minhas Apostas até o dia 11/06/2014. \n Preencha seu palpite em todos os jogos e não esqueça de cadastrar as seleções que ficarão em primeiro e segundo lugar de cada grupo.\n ");
				msg.append("Para maiores informações, acesse as Regras do bolão e a opção Ajuda no menu.\n");
				msg.append(
						"Caso não consiga efetuar seu login. Entre em contato com o Administrador atraves do email <bolaodacopabrasil@gmail.com> ou pelo telefone 87533736\n\n");
				msg.append("Atenciosamente,\n");
				msg.append("Administração do Bolão.\n\n");
				msg.append("E-mail gerado automaticamente, favor não responder.");

				/*
				 * bolaoUtil.enviaEmailSimples(participante,
				 * "Confirmação de pagamento",msg.toString());
				 */
			}

			limpar();

			FacesUtil.addInfoMessage("Operação realizada com sucesso.");
			// logger.info("Operação realizada com sucesso.");

		} catch (BolaoRuntimeException e) {
			FacesUtil.addErroMessage(e.getMessage());

		} catch (Exception e) {
			FacesUtil.addErroMessage("Ocorreu algum erro ao salvar. Operação cancelada.");

		}

		return "participanteForm";
	}

	public String limpaTelaCadastro() {
		limpar();
		return "cadastro?faces-redirect=true";
	}

	public String salvarCadastro() {

		try {

			// criptografando password e colocando para letra maiuscula
			try {
				participante.setPassword(bolaoUtil.criptografarSenha(participante.getPassword()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			// colocando em letra maiuscula para salvar
			participante.setNome(participante.getNome().toUpperCase());
			participante.setUsername(participante.getUsername().toUpperCase());

			participanteBusiness.salvar(participante);

			StringBuilder msg = new StringBuilder();
			msg.append("Prezado Administrador,\n\n");
			msg.append("O " + participante.getNome() + " de contato " + participante.getContato()
					+ " realizou seu cadastro com sucesso.\n");
			msg.append("Agora temos " + (participanteBusiness.findAll().size() - 1)
					+ " participantes cadastrados sendo " + (participanteBusiness.count("", 1) - 1) + " ativos.\n\n");
			msg.append("Atenciosamente,\n");
			msg.append("Administração do Bolão.\n\n");
			msg.append("E-mail gerado automaticamente, favor não responder.");
			// bolaoUtil.enviarEmailAdmin("Cadastro Participante
			// Bolão",msg.toString());
			participante = new Participante();

			FacesUtil.addInfoMessage(
					"Seu inscrição foi realizado com sucesso! Você receberá, em breve, um e-mail com mais informações para dar continuidade ao seu cadastro");

			RequestContext.getCurrentInstance().execute("dlg.show()");

		} catch (BolaoRuntimeException e) {
			FacesUtil.addErroMessage(e.getMessage());

		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.addErroMessage("Ocorreu algum erro ao salvar. Operação cancelada.");

		}

		return "cadastro";
	}

	/*
	 * public void enviarEmail() throws EmailException { StringBuilder msg = new
	 * StringBuilder();
	 * msg.append("Prezado(a) "+participante.getNome()+",\n\n"); msg.
	 * append("Obrigado pelo seu interesse em participar do nosso Bolão. Seu cadastro foi efetuado com sucesso!\n"
	 * ); msg.
	 * append("Apos a confirmação do pagamento você receberá um email informando a ativação do seu usuário.\n"
	 * ); msg.
	 * append("Só então você deve cadastrar suas apostas até o dia 11/06/2014.\n "
	 * ); msg.
	 * append("Para maiores informações, acesse as Regras do bolão e a opção Ajuda no menu(após está logado).\n"
	 * ); msg.
	 * append("Caso não consiga efetuar seu login após ter recebido seu email de ativação. Entre em contato com o Administrador atraves do email... ou pelo telefone 87533736\n\n"
	 * ); msg.append("Atenciosamente,\n");
	 * msg.append("Administração do Bolão.\n\n");
	 * msg.append("E-mail gerado automaticamente, favor não responder.");
	 * 
	 * bolaoUtil.enviaEmailSimples(participante,
	 * "Instruções para prosseguir seu cadastro",msg.toString()); }
	 */

	public String limpaTelaRecuperarSenha() {
		recuperarSehnaEmail = new String();
		recuperarSenhaLogin = new String();

		return "recuperarSenha";
	}

	public String recuperarSenha() {
		try {
			participanteBusiness.recuperarSenha(recuperarSenhaLogin, recuperarSehnaEmail);

			limpaTelaRecuperarSenha();
			FacesUtil.addInfoMessage(
					"Confirmação realizada com sucesso. Você receberá um e-mail com sua nova senha!");

		} catch (BolaoRuntimeException e) {
			FacesUtil.addErroMessage(e.getMessage());

		} catch (Exception e) {
			FacesUtil.addErroMessage("Ocorreu algum erro ao salvar. Operação cancelada.");

		}

		return "recuperarSenha";
	}

	public void selecionaContato() {
		if (contatoOpcao == 1) {
			participante.setContato("TCE");
		} else {
			participante.setContato(null);
		}
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante Participante) {
		this.participante = Participante;
	}

	public boolean isAlterar() {
		return alterar;
	}

	public void setAlterar(boolean alterar) {
		this.alterar = alterar;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRecuperarSenhaLogin() {
		return recuperarSenhaLogin;
	}

	public void setRecuperarSenhaLogin(String recuperarSenhaLogin) {
		this.recuperarSenhaLogin = recuperarSenhaLogin;
	}

	public String getRecuperarSehnaEmail() {
		return recuperarSehnaEmail;
	}

	public void setRecuperarSehnaEmail(String recuperarSehnaEmail) {
		this.recuperarSehnaEmail = recuperarSehnaEmail;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public int getContatoOpcao() {
		return contatoOpcao;
	}

	public void setContatoOpcao(int contatoOpcao) {
		this.contatoOpcao = contatoOpcao;
	}

}
