package com.bolao.dao;

import java.util.List;

import com.bolao.model.Grupo;
import com.bolao.model.Participante;
import com.bolao.model.Time;

public interface TimeDAO {
	
	public void salvar(Time time);

	public void excluir(Time time);
	
	public List<Time> buscar();
	
	public Time buscar (String nome);
	
	public Time buscar (Long id);
	
	public Time findByNome(String nome);
	
	public List<Time> findAllTime(int inicio, int max);
	
	public Time findById(Long id);
	
	public List<Time> findByGrupo(Grupo grupo);

	public List<Time> search(String nome);
	
	public List<Time> findTime(String nome, int startingAt, int maxPerPage);

	public Time findNomeByGrupo(String nome, Grupo grupo);
	
	public int countByGrupo(Grupo sistema, String nome);
	
	public int countByNome(String nome);
	
	public List<Time> search(String nome, int first, int rows);
	
	/*public List<Time> findByGrupoPaginado(String nome, Grupo grupo, int inicio, int maxPerPage);*/ 
	
	public List<Time> findByCriterios(String nome, Grupo grupo);

	public List<Time> findTimeNaoClassificadaByGrupo(Grupo grupo); 
	
	public List<Time> findTimeNaoClassificadaByGrupoParticipante(Grupo grupo, Participante participante);
	
}