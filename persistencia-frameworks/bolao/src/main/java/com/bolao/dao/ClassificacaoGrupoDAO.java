package com.bolao.dao;

import java.util.List;

import com.bolao.model.ClassificacaoGrupo;
import com.bolao.model.Grupo;



public interface ClassificacaoGrupoDAO {
	
	public void salvar(ClassificacaoGrupo classificacaoGrupo);
	
	public void excluir(ClassificacaoGrupo classificacaoGrupo);
	
	public List<ClassificacaoGrupo> findAllOk();
	
	public List<ClassificacaoGrupo> findByCriterios(Grupo grupo); 
	
	public ClassificacaoGrupo findById(Long id);

	public ClassificacaoGrupo findByGrupo(Grupo grupo);
	
}
