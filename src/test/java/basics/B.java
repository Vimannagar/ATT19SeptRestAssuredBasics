package basics;

public class B {
	
	
	
	public void m1()
	{
		System.out.println("first line of m1");
		new A().getCity();
	}
	
	
	public static void main(String[] args) {
		
		B b = new B();
		
		b.m1();
		
		
	}
	

}
