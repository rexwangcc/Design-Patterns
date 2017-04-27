package template;

public abstract class CaffeineBeverageWithHook {
	// Our template method
	final void prepareReceipe(){
		boilWater();
		brew();
		pourInCup();
		if(customerWantsCondiments()){
			addCondiments();
		}
	}
	
	abstract void brew();
	
	abstract void addCondiments();
	
	void boilWater(){
		System.out.println("Boiling water...");
	}
	
	void pourInCup(){
		System.out.println("Pouring into cup!!");
	}
	
	boolean customerWantsCondiments(){
		return true;
	}
	
}
