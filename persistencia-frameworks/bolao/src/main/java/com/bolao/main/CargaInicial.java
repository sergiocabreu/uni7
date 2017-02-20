package com.bolao.main;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

import org.hibernate.Session;

import com.bolao.dao.GenericDao;
import com.bolao.model.ApostaClassificacaoGrupo;
import com.bolao.model.ApostaJogo;
import com.bolao.model.Bolao;
import com.bolao.model.Cartela;
import com.bolao.model.Grupo;
import com.bolao.model.Jogos;
import com.bolao.model.Participante;
import com.bolao.model.ParticipanteBolao;
import com.bolao.model.ParticipanteCartela;
import com.bolao.model.Time;
import com.bolao.model.TimeBolao;
import com.bolao.util.HibernateFactory;


public class CargaInicial {

	public static void main(String[] args) throws Exception {

		Session session = HibernateFactory.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();

		GenericDao  gd = new GenericDao();
		
		

		// ------------ Criando o bolão ---------
		Bolao b1 = new Bolao();
		b1.setCampeonato("Liga dos Campeões");
		b1.setAno("2016");
		b1.setObservacao("Analisando só a primeira fase");
		 

		gd.salvar(b1);
		
		// ------------ Criando participantes---------
		
		// criando um admin
		
		Participante admin = new Participante();
		admin.setNome("Administrador");
		admin.setUsername("ADMIN");
		admin.setEmail("zacariasgsn@gmail.com");
		admin.setTelefone("34781803");
		admin.setPassword(toMd5("1"));
		admin.setAtivo(true);
		admin.setFlAdmin(true);
		
		gd.salvar(admin);
		
		Participante p1 = new Participante();
		p1.setNome("Luke");
		p1.setUsername("LUKE");
		p1.setEmail("zacariasgsn@gmail.com");
		p1.setTelefone("34781803");
		p1.setPassword(toMd5("1"));
		p1.setAtivo(true);
		p1.setFlAdmin(false);
		
		gd.salvar(p1);
		
		Participante p2 = new Participante();
		p2.setNome("Glen");
		p2.setUsername("GLEN");
		p2.setEmail("zacariasgsn@gmail.com");
		p2.setTelefone("34781803");
		p2.setPassword(toMd5("1"));
		p2.setAtivo(true);
		p2.setFlAdmin(false);
		
		gd.salvar(p2);
		
		// ------------ Liagando o Participante ao bolão---------
		
		ParticipanteBolao pb1 = new ParticipanteBolao();
		pb1.setBolao(b1);
		pb1.setParticipante(p1);
		pb1.setQtdeEscoresCheios(0);
		pb1.setTotalPontos(0);
		
		gd.salvar(pb1);
		
		ParticipanteBolao pb2 = new ParticipanteBolao();
		pb2.setBolao(b1);
		pb2.setParticipante(p2);
		pb2.setQtdeEscoresCheios(0);
		pb2.setTotalPontos(0);
		
		gd.salvar(pb2);
		
		
		// ------------ Criando grupos---------
		
		Grupo g1 = new Grupo();
		g1.setNome("A");
		
		gd.salvar(g1);
		
		Grupo g2 = new Grupo();
		g2.setNome("B");
		
		gd.salvar(g2);
		
		// ------------ Criando times---------
		
		Time t1 = new Time();
		t1.setNome("Barcelona");
		t1.setGrupo(g1);
		
		gd.salvar(t1);
		
		Time t2 = new Time();
		t2.setNome("Real Madri");
		t2.setGrupo(g1);
		
		gd.salvar(t2);
		
		Time t3 = new Time();
		t3.setNome("Juventus");
		t3.setGrupo(g1);
		
		gd.salvar(t3);
		
		Time t4 = new Time();
		t4.setNome("Corinthians");
		t4.setGrupo(g1);
		
		gd.salvar(t4);
		
		// ------------ Ligando os times do bolão ---------
		
		TimeBolao tb1 = new TimeBolao();
		tb1.setTime(t1);
		tb1.setBolao(b1);
		
		gd.salvar(tb1);
		
		TimeBolao tb2 = new TimeBolao();
		tb2.setTime(t2);
		tb2.setBolao(b1);
		
		gd.salvar(tb2);
		
		TimeBolao tb3 = new TimeBolao();
		tb3.setTime(t3);
		tb3.setBolao(b1);
		
		gd.salvar(tb3);
		
		TimeBolao tb4 = new TimeBolao();
		tb4.setTime(t4);
		tb4.setBolao(b1);
		
		gd.salvar(tb4);
		
		// ------------ Cadastro Jogos ---------
		Calendar dtJogo = Calendar.getInstance();

		dtJogo.set(Calendar.YEAR, 2016);
		dtJogo.set(Calendar.MONTH, Calendar.AUGUST);
		dtJogo.set(Calendar.DAY_OF_MONTH, 11);
		
		Jogos j1 = new Jogos();
		j1.setBolao(b1);
		j1.setFlResultadoOk(false);
		j1.setDtJogo(dtJogo.getTime());
		j1.setTime1(t1);
		j1.setTime2(t4);
		
		gd.salvar(j1);
		
		Jogos j2 = new Jogos();
		j2.setBolao(b1);
		j2.setFlResultadoOk(false);
		j2.setDtJogo(dtJogo.getTime());
		j2.setTime1(t2);
		j2.setTime2(t3);
		
		gd.salvar(j2);
		
		// ------------ Cadastro Cartela de aposta   ---------
		Cartela c1 =  new Cartela();
		c1.setNumero(1);
		c1.setBolao(b1);
		
		gd.salvar(c1);
		
		Cartela c2 =  new Cartela();
		c2.setNumero(2);
		c2.setBolao(b1);
		
		gd.salvar(c2);
		
		// ------------ Cadastro Aposta jogos  ---------
		ApostaJogo aj1 = new ApostaJogo();
		aj1.setCartela(c1);
		aj1.setJogos(j1);
		aj1.setGol1(2);
		aj1.setGol2(1);
		
		gd.salvar(aj1);
		
		ApostaJogo aj2 = new ApostaJogo();
		aj2.setCartela(c1);
		aj2.setJogos(j1);
		aj2.setGol1(1);
		aj2.setGol2(3);
		
		gd.salvar(aj2);
		
		ApostaJogo aj3 = new ApostaJogo();
		aj3.setCartela(c2);
		aj3.setJogos(j1);
		aj3.setGol1(1);
		aj3.setGol2(2);
		
		gd.salvar(aj3);
		
		ApostaJogo aj4 = new ApostaJogo();
		aj4.setCartela(c2);
		aj4.setJogos(j1);
		aj4.setGol1(1);
		aj4.setGol2(3);
		
		gd.salvar(aj4);
		
		// ------------ Cadastro Aposta Classificação Grupo  ---------
		ApostaClassificacaoGrupo apcg1 = new ApostaClassificacaoGrupo();
		apcg1.setCartela(c1);
		apcg1.setGrupo(g1);
		apcg1.setPosicao1(t4);
		apcg1.setPosicao2(t1);
		
		gd.salvar(apcg1);
		
		ApostaClassificacaoGrupo apcg2 = new ApostaClassificacaoGrupo();
		apcg2.setCartela(c2);
		apcg2.setGrupo(g1);
		apcg2.setPosicao1(t2);
		apcg2.setPosicao2(t1);
		
		gd.salvar(apcg2);
		
		// ------------ Cadastro Cartela Participante   ---------
		ParticipanteCartela pc1 = new ParticipanteCartela();
		pc1.setCartela(c1);
		pc1.setParticipante(p1);
		
		gd.salvar(pc1);
		
		ParticipanteCartela pc2 = new ParticipanteCartela();
		pc2.setCartela(c2);
		pc2.setParticipante(p2);
		
		gd.salvar(pc2);
		
		session.getTransaction().commit();
	}
	private static String toMd5(String valor) {
		String md5 = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			BigInteger hashForm = new BigInteger(1, md.digest(valor.getBytes()));
			md5 = hashForm.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}
}
