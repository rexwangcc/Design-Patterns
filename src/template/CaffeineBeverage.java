package template;

public abstract class CaffeineBeverage {
	// Our template method
	final void prepareReceipe(){
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}
	
	abstract void brew();
	
	abstract void addCondiments();
	
	void boilWater(){
		System.out.println("Boiling water...");
	}
	
	void pourInCup(){
		System.out.println("Pouring into cup!!");
	}
	
}
