package basics;

public class A {
	
private	String city;
private int pincode;
	
	
	public void setCity(String city)
	{
		 this.city= city;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setPincode(int pincode)
	{
		 this.pincode= pincode;
	}
	
	public int getPincode()
	{
		return pincode;
	}
	
	
	public static void main(String[] args) {
		
		A a = new A();
		
		
		a.setCity("Pune");
		
		System.out.println(a.getCity());
		
		
		
		
	}
	
	
}
