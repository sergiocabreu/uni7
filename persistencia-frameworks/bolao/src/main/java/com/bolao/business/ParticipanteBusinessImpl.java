package com.bolao.business;

import java.util.List;
import java.util.Random;

import com.bolao.dao.ParticipanteDAO;
import com.bolao.dao.ParticipanteDAOImpl;
import com.bolao.exception.BolaoRuntimeException;
import com.bolao.model.Participante;
import com.bolao.util.BolaoUtil;




public class ParticipanteBusinessImpl implements ParticipanteBusiness{

	
	private ParticipanteDAO participanteDAO;
	

	private BolaoUtil bolaoUtil;
	
	public ParticipanteBusinessImpl() {

		try {
			participanteDAO = new ParticipanteDAOImpl();
			bolaoUtil = new BolaoUtil();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Participante findByUsername(String nome) {

		return participanteDAO.findByUsername(nome);
	}

	@Override
	public List<Participante> searchByNome(String nome) {
		
		validaNomeParticipante(nome);
		List<Participante> usuarioList = participanteDAO.searchByNome(nome, 1);
		if(usuarioList.isEmpty()){
			throw new BolaoRuntimeException("Nenhum resultado retornado");
		}
		
		return usuarioList;

	}

	
	@Override
	public Participante findByParticipante(Participante participante) {
		
		if(participante.getId() == null || participante.getId() == 0) {
			throw new BolaoRuntimeException("O usuário não foi selecionado.");
		}
		return participanteDAO.findByParticipante(participante);
	}

	@Override
	public void salvar(Participante participante) {
		
		verificaAlteracao(participante);
		
		if(!participante.getEmail().isEmpty()) {
			if(!bolaoUtil.validarEmail(participante.getEmail()))
			{
				throw new BolaoRuntimeException("E-mail inválido");
			}
		}
		
		participanteDAO.salvar(participante);
	}

	public void verificaAlteracao(Participante participante)
	{
		//se é um novo usuário
		if(participante.getId() == null)
		{
			verificaParticipanteExistenteUsername(participante);
//			if(dao.findByEmail(participante.getEmail()) != null){
//				throw new BolaoRuntimeException("Esse e-mail já foi cadastrado");
//			}
		}
		//se é apenas uma alteração
		else
		{
			Participante user = findByParticipante(participante);
			if( !user.getUsername().equals(participante.getUsername()))
			{
				verificaParticipanteExistenteUsername(participante);
			}
		}
	}	
	public void verificaParticipanteExistenteUsername(Participante Participante)
	{
		Participante u = findByUsername(Participante.getUsername());
		if(u != null) {
			throw new BolaoRuntimeException("Já existe um Usuário cadastrado com esse Login.");
		}
	}

	@Override
	public List<Participante> findByNome(String nome, int ativo, int inicio, int maxPerPage) {
		return participanteDAO.findByNome(nome, ativo, inicio, maxPerPage);
	}

	@Override
	public int count(String nome, int ativo) {
		return participanteDAO.count(nome, ativo);
	}
	
	private void validaNomeParticipante(String nomeUsuario) throws BolaoRuntimeException
	{
		if (nomeUsuario.length() < 3)
			 throw new BolaoRuntimeException("O Nome do Usuário deve possuir no mínimo 3(três) caracteres.");
	}

	@Override
	public void recuperarSenha(String login, String email) {
		Random chave = new Random();
		Participante participante = participanteDAO.findByLoginAndEmail(login.toUpperCase(), email);
		if(participante != null){
			try {
				String newPassword = new String(participante.getUsername()+chave.nextInt(99)+1);
				//bolaoUtil.enviaEmailSimples(participante, "Recuperar senha", "Sua nova senha de acesso: "+newPassword);
				participante.setPassword(bolaoUtil.criptografarSenha(newPassword));
			} catch (Exception e) {
				e.printStackTrace();
			}
			salvar(participante);
		}
		else{
			throw new BolaoRuntimeException("Login ou email não cadastrados");
		}
		
	}
	
	@Override
	public List<Participante> findAll() {
		return participanteDAO.findAll();

	}
	
	@Override
	public List<Participante> findAllOk() {
		return participanteDAO.findAllOk();

	}
}
