package com.bolao.business;

import java.util.List;

import com.bolao.exception.NomeObrigatorioException;
import com.bolao.exception.TimeJaCadastradoException;
import com.bolao.model.Grupo;
import com.bolao.model.Time;

public interface TimeBusiness {

	public void salvar(Time time) throws TimeJaCadastradoException, NomeObrigatorioException, GrupoObrigatorioException;
	
	public void excluir(Time time);
	
	public List<Time> buscar();
	
	public List<Grupo> grupos();

}
