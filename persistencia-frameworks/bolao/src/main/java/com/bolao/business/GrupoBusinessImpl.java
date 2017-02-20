package com.bolao.business;

import java.util.List;

import com.bolao.dao.GrupoDAO;
import com.bolao.dao.GrupoDAOImpl;
import com.bolao.exception.GrupoJaCadastradoException;
import com.bolao.exception.NomeObrigatorioException;
import com.bolao.model.Grupo;

public class GrupoBusinessImpl implements GrupoBusiness {

	private GrupoDAO grupoDao;

	public GrupoBusinessImpl() {
		
		try {
			grupoDao = new GrupoDAOImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void salvar(Grupo grupo) throws GrupoJaCadastradoException, NomeObrigatorioException {
		
		validaGrupo(grupo);
		
		grupoDao.salvar(grupo);
	}

	private void validaGrupo(Grupo grupo) throws GrupoJaCadastradoException, NomeObrigatorioException {
		
		if (grupo.getNome() == null || grupo.getNome().isEmpty())
			throw new NomeObrigatorioException("Nome do grupo é obrigatório");
		
		if (grupoDao.buscar(grupo.getNome()) != null) 
			throw new GrupoJaCadastradoException("Grupo já cadastrado");
	}

	@Override
	public void excluir(Grupo grupo) {
		grupoDao.excluir(grupo);
	}

	@Override
	public List<Grupo> buscar() {
		return grupoDao.buscar();
	}
	
	
}
