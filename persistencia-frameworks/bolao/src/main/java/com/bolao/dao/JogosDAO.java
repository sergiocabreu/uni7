package com.bolao.dao;

import java.util.Date;
import java.util.List;

import com.bolao.model.Grupo;
import com.bolao.model.Jogos;



public interface JogosDAO {
	
	public void salvar(Jogos jogos);
	
	public void excluir(Jogos jogos);

	public List<Jogos> findByCriterios(Date datajogo, Grupo grupo); 
	
	public List<Jogos> findAll();
	
	public List<Jogos> findAllOk();

	public Jogos findById(Long id);
	
}
