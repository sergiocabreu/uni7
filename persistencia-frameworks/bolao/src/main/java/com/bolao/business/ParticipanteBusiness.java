package com.bolao.business;

import java.util.List;

import com.bolao.model.Participante;



public interface ParticipanteBusiness {
	
	public Participante findByUsername(String nome);
	
	public List<Participante> searchByNome(String nome);
	
	public Participante findByParticipante(Participante Participante);
	
	public void salvar(Participante Participante);
	
	public List<Participante> findByNome(String nome, int ativo, int inicio, int maxPerPage);
	
	public int count(String nome, int ativo);
	
	public void recuperarSenha(String login, String email);
	
	public List<Participante> findAllOk();
	
	public List<Participante> findAll();
}
