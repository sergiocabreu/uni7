/**
 * 
 */
package com.bolao.business;

import java.util.Date;
import java.util.List;

import com.bolao.dao.GrupoDAO;
import com.bolao.dao.GrupoDAOImpl;
import com.bolao.dao.JogosDAO;
import com.bolao.dao.JogosDAOImpl;
import com.bolao.dao.TimeDAO;
import com.bolao.dao.TimeDAOImpl;
import com.bolao.model.Grupo;
import com.bolao.model.Jogos;
import com.bolao.model.Time;

public class JogosBusinessImpl implements JogosBusiness {

	private JogosDAO jogosDAO;
	private GrupoDAO grupoDAO;
	private TimeDAO timeDAO;

	public JogosBusinessImpl() {

		try {
			jogosDAO = new JogosDAOImpl();
			grupoDAO = new GrupoDAOImpl();
			timeDAO = new TimeDAOImpl();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setDAO(JogosDAO dao) {
		this.jogosDAO = dao;
	}

	@Override
	public void salvar(Jogos jogo) {
		jogosDAO.salvar(jogo);
	}

	@Override
	public void excluir(Jogos Jogos) {
		jogosDAO.excluir(Jogos);
	}

	@Override
	public List<Jogos> findByCriterios(Date datajogo, Grupo grupo) {
		return jogosDAO.findByCriterios(datajogo, grupo);
	}

	@Override
	public Jogos findById(Long id) {
		return jogosDAO.findById(id);
	}

	@Override
	public List<Jogos> findAll() {
		return jogosDAO.findAll();
	}

	@Override
	public List<Jogos> findAllOk() {
		return jogosDAO.findAllOk();
	}

	@Override
	public List<Grupo> grupos() {
		return grupoDAO.buscar();
	}

	@Override
	public List<Time> times(Grupo grupo) {
		return timeDAO.findByGrupo(grupo);
	}
}
