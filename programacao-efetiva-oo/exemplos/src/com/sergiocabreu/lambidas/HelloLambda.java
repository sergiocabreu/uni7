package com.sergiocabreu.lambidas;

public class HelloLambda {

	public interface HelloType{
		public void sayHello(String text);
	}
	
	public static void main(String[] args) {
		HelloType english = (text) -> System.out.println("Hello " + text);
		HelloType portuguese = (text) -> System.out.println("Olá " + text);
		
		HelloLambda helloLambda = new HelloLambda();
		helloLambda.greeting(english, "Sérgio");
		helloLambda.greeting(portuguese, "Sérgio");
		
		helloLambda.greeting((text) -> System.out.println("Hello " +text), "Sérgio");
		
		helloLambda.greeting(new HelloType() {
			
			@Override
			public void sayHello(String text) {
				System.out.println("Olá " + text);
			}
		}, "Sérgio");
	}
	
	public void greeting(HelloType helloType, String name){
		helloType.sayHello(name);
	}

}
