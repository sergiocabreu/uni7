package com.bolao.business;

import java.util.List;

import com.bolao.dao.ClassificacaoGrupoDAO;
import com.bolao.model.ClassificacaoGrupo;
import com.bolao.model.Grupo;



public interface ClassificacaoGrupoBusiness {
	
	public List<ClassificacaoGrupo> findAllOk();
	
	public void setDAO(ClassificacaoGrupoDAO dao);
	
	public void salvar(ClassificacaoGrupo classificacaoGrupo);
	
	public void excluir(ClassificacaoGrupo classificacaoGrupo);
    
	public ClassificacaoGrupo findById(Long id);
	
	public List<ClassificacaoGrupo> findByCriterios(Grupo grupo); 
	
	public ClassificacaoGrupo findByGrupo(Grupo grupo); 
	
}
