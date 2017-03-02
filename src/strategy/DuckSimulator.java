package strategy;

public class DuckSimulator {
	public static void main(String[] args){
		
		// Mallard Duck
		Duck mallard = new MallardDuck();
		mallard.performFly();
		mallard.performQuack();
		
		// Model Duck
		Duck modelduck = new ModelDuck();
		modelduck.performFly();
		modelduck.performQuack();
		//Change actions at runtime
		modelduck.setFlyBehavior(new FlyWithRockets());
		modelduck.performFly();
		
	}
}
