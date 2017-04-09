package command;

public class Light {
	String name = "light";
	
	public Light(String name){
		this.name = name;
	}
	
	public Light(){
	}
	
	
	public void on(){
		System.out.println(this.name + " Light is On :)");
	}
	
	public void off(){
		System.out.println(this.name + " Light is Off :(");
	}
}
