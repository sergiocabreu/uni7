package com.bolao.dao;

import java.util.List;

import com.bolao.model.Bolao;

public interface BolaoDAO {

	public void salvar(Bolao bolao);

	public void excluir(Bolao bolao);

	public List<Bolao> buscar();

	public Bolao buscar(String nome);

	public Bolao buscar(Long id);

	public int count(String nome);

	public List<Bolao> search(String nome, int first, int rows);

	public List<Bolao> searchByNome(String nome);

	public Bolao findByBolao(Bolao bolao);

	public Bolao findByNome(String nome);

	public Bolao findById(Long id);

}