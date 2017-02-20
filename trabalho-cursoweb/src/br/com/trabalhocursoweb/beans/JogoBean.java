package br.com.trabalhocursoweb.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.trabalhocursoweb.tipo.JogadorEnum;

@ManagedBean(name="jogoBean")
@ViewScoped
public class JogoBean {
	
	private String nomeJogadorO;
	private String nomeJogadorX;
	private JogadorEnum jogadorAtual;
	
	private String mensagemChave;
	private String mensagemValor;
	
	private boolean travarTabuleiro;
	
	private int quantidadeJogadas;
	
	private JogadorEnum[][] tabuleiro = new JogadorEnum[3][3];
	
	/**
	 * Inicia uma nova partida.
	 */
	public void novo(){
		
		limpaTabuleiro();
		
		travarTabuleiro(false);
		
		quantidadeJogadas = 0;
		
		jogadorAtual = JogadorEnum.O;
		
		setMensagemChave("page.jogo.mensagem.vez");
		
		setMensagemValor(getNomeJogadorO());
	}

	private void travarTabuleiro(boolean b) {
		travarTabuleiro = b;
	}

	private void limpaTabuleiro() {
		tabuleiro = new JogadorEnum[3][3];
	}

	public void jogar(int pos1, int pos2){
		
		quantidadeJogadas++;
		
		tabuleiro[pos1][pos2] = jogadorAtual;
		
		if (jogadorAtual == JogadorEnum.O) {
			jogadorAtual = JogadorEnum.X;
			setMensagemValor(getNomeJogadorX());
		}
		else {
			jogadorAtual = JogadorEnum.O;
			setMensagemValor(getNomeJogadorO());
		}
				
		JogadorEnum ganhador = verificaGanhador();
		
		if(ganhador == null && quantidadeJogadas == 9) {
			travarTabuleiro = true;
			setMensagemChave("page.jogo.mensagem.empate");
		} else if (ganhador != null) {
			travarTabuleiro = true;
			setMensagemChave("page.jogo.mensagem.ganhador");
			
			if (ganhador == JogadorEnum.X)
				setMensagemValor(getNomeJogadorX());
			else setMensagemValor(getNomeJogadorO());
		}
	}
	
	private JogadorEnum verificaGanhador() {
		
		JogadorEnum pos1;
		JogadorEnum pos2;
		JogadorEnum pos3;
		
		//LINHAS
		for (int i = 0; i < 3; i++) {
			pos1 = tabuleiro[i][0];
			pos2 = tabuleiro[i][1];
			pos3 = tabuleiro[i][2];		
			
			if (pos1 == pos2 && pos1 == pos3 && pos2 == pos3)
				return pos1;
		}
		
		//COLUNAS
		for (int i = 0; i < 3; i++) {
			pos1 = tabuleiro[0][i];
			pos2 = tabuleiro[1][i];
			pos3 = tabuleiro[2][i];		
			
			if (pos1 == pos2 && pos1 == pos3 && pos2 == pos3)
				return pos1;
		}		
		//DIAGONAIS PRINCIPAL
		pos1 = tabuleiro[0][0];
		pos2 = tabuleiro[1][1];
		pos3 = tabuleiro[2][2];
		
		if (pos1 == pos2 && pos1 == pos3 && pos2 == pos3)
			return pos1;
		
		//DIAGONAIS SECUNDARIA
		pos1 = tabuleiro[0][2];
		pos2 = tabuleiro[1][1];
		pos3 = tabuleiro[2][0];
		
		if (pos1 == pos2 && pos1 == pos3 && pos2 == pos3)
			return pos1;
		
		return null;//Deu velha
	}

	public char tabuleiro(int pos1, int pos2) {
		return (tabuleiro[pos1][pos2] == null ? ' ' : tabuleiro[pos1][pos2].jogador);
	}
	
	public boolean desabilitar(int pos1, int pos2) {
		
		if (travarTabuleiro) 
			return travarTabuleiro;
		else {
			return (tabuleiro[pos1][pos2] == null ? false : true);
		}
	}	

	public String getNomeJogadorO() {
		return nomeJogadorO;
	}

	public void setNomeJogadorO(String nomeJogadorO) {
		this.nomeJogadorO = nomeJogadorO;
	}

	public String getNomeJogadorX() {
		return nomeJogadorX;
	}

	public void setNomeJogadorX(String nomeJogadorX) {
		this.nomeJogadorX = nomeJogadorX;
	}

	public JogadorEnum getJogadorAtual() {
		return jogadorAtual;
	}

	public void setJogadorAtual(JogadorEnum jogadorAtual) {
		this.jogadorAtual = jogadorAtual;
	}

	public String getMensagemChave() {
		return mensagemChave;
	}

	public void setMensagemChave(String mensagemChave) {
		this.mensagemChave = mensagemChave;
	}

	public String getMensagemValor() {
		return mensagemValor;
	}

	public void setMensagemValor(String mensagemValor) {
		this.mensagemValor = mensagemValor;
	}
}