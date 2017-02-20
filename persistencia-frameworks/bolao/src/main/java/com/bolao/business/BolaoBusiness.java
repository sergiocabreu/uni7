package com.bolao.business;

import java.util.List;

import com.bolao.exception.BolaoRuntimeException;
import com.bolao.model.Bolao;

public interface BolaoBusiness {

	public void salvar(Bolao bolao) throws BolaoRuntimeException;
	
	public void excluir(Bolao bolao);

	public List<Bolao> buscar();
}
