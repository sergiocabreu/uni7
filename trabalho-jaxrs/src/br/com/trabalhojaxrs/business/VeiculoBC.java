package br.com.trabalhojaxrs.business;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.trabalhojaxrs.dao.Repositorio;
import br.com.trabalhojaxrs.model.Veiculo;

@ApplicationScoped
public class VeiculoBC {

	@Inject
	private Repositorio repositorio;

	@PostConstruct
	public void inicializar() {

		Calendar data = Calendar.getInstance();		
		
		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca("AAA-0000");
		veiculo.setProprietario("Proprietario 0");
		veiculo.setEmplacamento(data.getTime());
		veiculo.setIpva(1000.00);
		repositorio.inserir(veiculo);
		
		veiculo = new Veiculo();
		veiculo.setPlaca("BBB-1111");
		veiculo.setProprietario("Proprietario 1");
		veiculo.setEmplacamento(data.getTime());
		veiculo.setIpva(2000.00);
		repositorio.inserir(veiculo);

		veiculo = new Veiculo();
		veiculo.setPlaca("CCC-2222");
		veiculo.setProprietario("Proprietario 2");
		veiculo.setEmplacamento(data.getTime());
		veiculo.setIpva(3000.00);
		repositorio.inserir(veiculo);
		
		veiculo = new Veiculo();
		veiculo.setPlaca("DDD-3333");
		veiculo.setProprietario("Proprietario 3");
		veiculo.setEmplacamento(data.getTime());
		veiculo.setIpva(4000.00);
		repositorio.inserir(veiculo);
	}

	public List<Veiculo> selecionar() {
		return repositorio.selecionar(Veiculo.class);
	}

	public Veiculo selecionar(Long id) throws VeiculoNaoEncontradoException {

		Veiculo veiculo = repositorio.selecionar(Veiculo.class, id);
		
		if (veiculo == null) {
			throw new VeiculoNaoEncontradoException();
		}
		return veiculo;
	}

	public Long inserir(Veiculo veiculo) {
		return repositorio.inserir(veiculo);
	}
	
	public Veiculo excluir(Long id) throws VeiculoNaoEncontradoException {
		Veiculo veiculo = repositorio.excluir(Veiculo.class, id);
		if (veiculo == null) {
			throw new VeiculoNaoEncontradoException();
		}
		return veiculo;
	}

	public void atualizar(Veiculo veiculo) throws VeiculoNaoEncontradoException {
		if (!repositorio.atualizar(veiculo)) {
			throw new VeiculoNaoEncontradoException();
		}
	}
}