package com.bolao.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class BolaoUtil {
	
	public boolean validarCPF(String cpf) 
	{ 
		cpf = removerMascara(cpf);
		
		int d1, d2, digito1, digito2, resto, digitoCPF;  
		String  nDigResult;  
		
		d1 = d2 = digito1 = digito2 = resto = 0;  
		
		for (int nCount = 1; nCount < cpf.length() -1; nCount++)  
		{  
			digitoCPF = Integer.valueOf (cpf.substring(nCount -1, nCount)).intValue();  
			//multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.  
			d1 = d1 + ( 11 - nCount ) * digitoCPF;  
			//para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.  
			d2 = d2 + ( 12 - nCount ) * digitoCPF;  
		};
		
		//Primeiro resto da divisão por 11.  
		resto = (d1 % 11);
		
		//Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
		if (resto < 2)  
			digito1 = 0;  
		else  
			digito1 = 11 - resto;  
		
		d2 += 2 * digito1;  
		
		//Segundo resto da divisão por 11.  
		resto = (d2 % 11);  
		
		//Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
		if (resto < 2)  
			digito2 = 0;  
		else  
			digito2 = 11 - resto;  
		
		//Digito verificador do CPF que está sendo validado.  
		String nDigVerific = cpf.substring (cpf.length()-2, cpf.length());  
		
		//Concatenando o primeiro resto com o segundo.  
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);  
		
		//comparar o digito verificador do cpf com o primeiro resto + o segundo resto.  
		return nDigVerific.equals(nDigResult);  
	}
	
	public String removerMascara(String string) 
	{
		string = string.replace(".", "");
		string = string.replace("-", "");
		string = string.replace("/", "");
		string = string.replace("(", "");
		string = string.replace(")", "");
		return string;
	}
	
	public boolean validarEmail(String email)
	{  
		return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}
	
	public String criptografarSenha(String senha) throws Exception 
	{
	   MessageDigest md = MessageDigest.getInstance("MD5"); 
	   BigInteger hash = new BigInteger(1, md.digest(senha.getBytes())); 
	   String s = hash.toString(16); 
	   if (s.length() %2 != 0) {
	      s = "0" + s; 
	   }
	   
	   return s; 
	}
	
/*	@SuppressWarnings("deprecation")
	public void enviaEmailSimples(Participante destinatario, String assunto, String mensagem) throws EmailException {  
		try{
	        SimpleEmail email = new SimpleEmail();  
	        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
	       // email.setHostName("webmail.tce.ce.gov.br");
	        email.addTo(destinatario.getEmail(), destinatario.getNome()); //destinatário  
	        email.setFrom("bolaodacopabrasil@gmail.com", "Bolão da Copa"); // remetente  
	        email.setSubject(assunto); // assunto do e-mail  
	        email.setMsg(mensagem); //conteudo do e-mail  
	        email.setAuthentication("bolaodacopabrasil", "bolao2014brasil");  
	        email.setSmtpPort(465); 
	       // email.setSmtpPort(25);
	        email.setSSL(true);  
	        email.setTLS(true); 
	        email.send();   
		} catch (EmailException e) {  
			throw new BolaoCopaDoMundoRuntimeException("Falha ao enviar e-mail de confirmação! Verifique se seu e-mail foi digitado corretamente, e se o erro persistir entre em contato com a administração.");  
  
        }
	} 
	
	@SuppressWarnings("deprecation")
	public void enviarEmailAdmin( String assunto, String mensagem) throws EmailException {  
		try{
	        SimpleEmail email = new SimpleEmail();  
	        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
	       // email.setHostName("webmail.tce.ce.gov.br");
	        email.addTo("bolaodacopabrasil@gmail.com", "Administrador"); //destinatário  
	        email.setFrom("bolaodacopabrasil@gmail.com", "Bolão da Copa"); // remetente  
	        email.setSubject(assunto); // assunto do e-mail  
	        email.setMsg(mensagem); //conteudo do e-mail  
	        email.setAuthentication("bolaodacopabrasil", "bolao2014brasil");  
	        email.setSmtpPort(465); 
	       // email.setSmtpPort(25);
	        email.setSSL(true);  
	        email.setTLS(true); 
	        email.send();   
		} catch (EmailException e) {  
			throw new BolaoCopaDoMundoRuntimeException("Falha ao enviar e-mail de confirmação! Verifique se seu e-mail foi digitado corretamente, e se o erro persistir entre em contato com a administração.");  
  
        }
	} */
	 
}
