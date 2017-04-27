package template;

public class TestMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Make Tea
		Tea myTea = new Tea();
		myTea.boilWater();
		myTea.brew();
		myTea.pourInCup();
		myTea.addCondiments();
		
		System.out.println("********");
		
		//Make Coffe
		Coffee myCoffee = new Coffee();
		myCoffee.boilWater();
		myCoffee.brew();
		myCoffee.pourInCup();
		myCoffee.addCondiments();
		
		System.out.println("********");
		
		//Custom Coffee
		CoffeeWithHook coffeeHook = new CoffeeWithHook();
		coffeeHook.prepareReceipe();
	}

}
