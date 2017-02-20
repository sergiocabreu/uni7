package com.bolao.business;

import java.util.List;

import com.bolao.exception.GrupoJaCadastradoException;
import com.bolao.exception.NomeObrigatorioException;
import com.bolao.model.Grupo;

public interface GrupoBusiness {

	public void salvar(Grupo grupo) throws GrupoJaCadastradoException, NomeObrigatorioException;
	
	public void excluir(Grupo grupo);

	public List<Grupo> buscar();
}
