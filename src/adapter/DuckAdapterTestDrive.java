package adapter;

public class DuckAdapterTestDrive{
	public static void main(String[] args){
		MallardDuck mallardDuck = new MallardDuck();
		
		WildTurkey wildTurkey = new WildTurkey();
		Duck turkeyAdapter = new TurkeyAdapter(wildTurkey);
		
		System.out.println("----- Testing Turkey -----");
		System.out.println("The Turkey says:");
		wildTurkey.gobble();
		wildTurkey.fly();
		
		System.out.println("----- Testing Duck -----");
		testDuck(mallardDuck);
		
		System.out.println("----- Testing Turkey as a Duck! -----");
		testDuck(turkeyAdapter);
		
	}
	
	static void testDuck(Duck duck){
		duck.quack();
		duck.fly();
	}
}
