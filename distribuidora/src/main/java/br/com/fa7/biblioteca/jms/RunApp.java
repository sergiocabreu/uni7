package br.com.fa7.biblioteca.jms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class RunApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new 
				AnnotationConfigApplicationContext(AppConfig.class);
		
	}

}
