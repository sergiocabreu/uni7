package com.bolao.business;

import java.util.List;

import com.bolao.dao.GrupoDAO;
import com.bolao.dao.GrupoDAOImpl;
import com.bolao.dao.TimeDAO;
import com.bolao.dao.TimeDAOImpl;
import com.bolao.exception.NomeObrigatorioException;
import com.bolao.exception.TimeJaCadastradoException;
import com.bolao.model.Grupo;
import com.bolao.model.Time;

public class TimeBusinessImpl implements TimeBusiness {

	private TimeDAO timeDAO;
	private GrupoDAO grupoDAO;

	public TimeBusinessImpl() {
		
		try {
			timeDAO = new TimeDAOImpl();
			grupoDAO = new GrupoDAOImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void salvar(Time time) throws TimeJaCadastradoException, NomeObrigatorioException, GrupoObrigatorioException {
		
		validarTime(time);
		
		timeDAO.salvar(time);
	}

	private void validarTime(Time time) throws TimeJaCadastradoException, NomeObrigatorioException, GrupoObrigatorioException {
		
		if (time.getNome() == null || time.getNome().isEmpty())
			throw new NomeObrigatorioException("Nome obrigatório");
		
		if (time.getGrupo() == null)
			throw new GrupoObrigatorioException("Grupo Obrigatorio");
		
		if (timeDAO.findNomeByGrupo(time.getNome(), time.getGrupo()) != null)
			throw new TimeJaCadastradoException("Time já cadastrado");
		
		
	}

	@Override
	public void excluir(Time time) {
		timeDAO.excluir(time);
	}

	@Override
	public List<Time> buscar() {
		return timeDAO.buscar();
	}

	@Override
	public List<Grupo> grupos() {
		return grupoDAO.buscar();
	}

}
