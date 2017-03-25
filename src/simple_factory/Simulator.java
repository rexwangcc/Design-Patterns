package simple_factory;

public class Simulator {
	public static void main(String args[]){
		SimplePizzaFactory boston_factory = new SimplePizzaFactory();
		PizzaStore boston_store = new PizzaStore(boston_factory);
		
		System.out.println(boston_store.orderPizza("cheese").description);
		System.out.println(boston_store.orderPizza("clam").description);
	}
}
