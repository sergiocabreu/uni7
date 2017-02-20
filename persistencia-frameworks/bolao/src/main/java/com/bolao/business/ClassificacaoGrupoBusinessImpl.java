/**
 * 
 */
package com.bolao.business;

import java.util.List;

import com.bolao.dao.ClassificacaoGrupoDAO;
import com.bolao.dao.ClassificacaoGrupoDAOImpl;
import com.bolao.dao.GrupoDAOImpl;
import com.bolao.model.ClassificacaoGrupo;
import com.bolao.model.Grupo;

public class ClassificacaoGrupoBusinessImpl implements ClassificacaoGrupoBusiness {

	private ClassificacaoGrupoDAO classificacaoGrupoDAO;

	public ClassificacaoGrupoBusinessImpl() {

		try {
			classificacaoGrupoDAO = new ClassificacaoGrupoDAOImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ClassificacaoGrupo> findAllOk() {
		return classificacaoGrupoDAO.findAllOk();
	}

	@Override
	public void setDAO(ClassificacaoGrupoDAO dao) {
		this.classificacaoGrupoDAO = dao;
	}

	@Override

	public void salvar(ClassificacaoGrupo classificacaoGrupo) {
		classificacaoGrupoDAO.salvar(classificacaoGrupo);
	}

	@Override
	public void excluir(ClassificacaoGrupo classificacaoGrupo) {
		classificacaoGrupoDAO.excluir(classificacaoGrupo);
	}

	@Override
	public List<ClassificacaoGrupo> findByCriterios(Grupo grupo) {
		return classificacaoGrupoDAO.findByCriterios(grupo);
	}

	@Override
	public ClassificacaoGrupo findById(Long id) {
		return classificacaoGrupoDAO.findById(id);
	}

	@Override
	public ClassificacaoGrupo findByGrupo(Grupo grupo) {
		return classificacaoGrupoDAO.findByGrupo(grupo);
	}

}
