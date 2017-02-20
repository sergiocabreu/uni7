package com.bolao.business;

import java.util.Date;
import java.util.List;

import com.bolao.dao.JogosDAO;
import com.bolao.model.Grupo;
import com.bolao.model.Jogos;
import com.bolao.model.Time;



public interface JogosBusiness {

	public void setDAO(JogosDAO dao);
	
	public void salvar(Jogos Jogos);
	
	public void excluir(Jogos Jogos);
    
	public List<Jogos> findAll();
	
	public Jogos findById(Long id);

	public List<Jogos> findAllOk();

	public List<Jogos> findByCriterios(Date datajogo, Grupo grupo); 

	public List<Grupo> grupos();
	
	public List<Time> times(Grupo grupo);	
}
