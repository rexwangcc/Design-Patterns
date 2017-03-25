package decorator;

public class Mocha extends CondimentDecorator{
	Beverage mocha_beverage;
	
	public Mocha(Beverage beverage){
		this.mocha_beverage = beverage;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return mocha_beverage.getDescription() + ", with Mocha";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return mocha_beverage.cost() + .2;
	}
	

}
