package com.sergiocabreu.lambidas;

public class HelloLambda {

	public interface HelloType{
		public void sayHello(String text);
	}
	
	public static void main(String[] args) {
		HelloType english = (text) -> System.out.println("Hello " + text);
		HelloType portuguese = (text) -> System.out.println("Ol� " + text);
		
		HelloLambda helloLambda = new HelloLambda();
		helloLambda.greeting(english, "S�rgio");
		helloLambda.greeting(portuguese, "S�rgio");
		
		helloLambda.greeting((text) -> System.out.println("Hello " +text), "S�rgio");
		
		helloLambda.greeting(new HelloType() {
			
			@Override
			public void sayHello(String text) {
				System.out.println("Ol� " + text);
			}
		}, "S�rgio");
	}
	
	public void greeting(HelloType helloType, String name){
		helloType.sayHello(name);
	}

}
