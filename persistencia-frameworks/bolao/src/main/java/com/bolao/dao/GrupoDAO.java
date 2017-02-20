package com.bolao.dao;

import java.util.List;

import com.bolao.model.Grupo;

public interface GrupoDAO {

	public void salvar(Grupo grupo);

	public void excluir(Grupo grupo);

	public List<Grupo> buscar();

	public Grupo buscar(String nome);

	public Grupo buscar(Long id);

	public int count(String nome);

	public List<Grupo> search(String nome, int first, int rows);

	public List<Grupo> searchByNome(String nome);

	public Grupo findByGrupo(Grupo grupo);

	public Grupo findByNome(String nome);

	public Grupo findById(Long id);

}