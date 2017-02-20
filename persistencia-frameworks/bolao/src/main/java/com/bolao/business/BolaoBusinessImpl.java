package com.bolao.business;

import java.util.List;

import com.bolao.dao.BolaoDAO;
import com.bolao.dao.BolaoDAOImpl;
import com.bolao.exception.BolaoRuntimeException;
import com.bolao.model.Bolao;

public class BolaoBusinessImpl implements BolaoBusiness {

	private BolaoDAO bolaoDao;

	public BolaoBusinessImpl() {
		
		try {
			bolaoDao = new BolaoDAOImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void salvar(Bolao Bolao) throws BolaoRuntimeException{
		
		validaBolao(Bolao);
		
		bolaoDao.salvar(Bolao);
	}

	private void validaBolao(Bolao bolao) throws BolaoRuntimeException {
		
		if (bolao.getCampeonato() == null || bolao.getCampeonato().isEmpty())
			throw new BolaoRuntimeException("Nome do Bolao é obrigatório");
		
		if (bolaoDao.buscar(bolao.getCampeonato()) != null) 
			throw new BolaoRuntimeException("Bolao já cadastrado");
	}

	@Override
	public void excluir(Bolao Bolao) {
		bolaoDao.excluir(Bolao);
	}

	@Override
	public List<Bolao> buscar() {
		return bolaoDao.buscar();
	}
	
	
}
