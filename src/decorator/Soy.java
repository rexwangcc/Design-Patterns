package decorator;

public class Soy extends CondimentDecorator{
	Beverage Soy_beverage;
	public Soy(Beverage beverage){
		this.Soy_beverage = beverage;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return Soy_beverage.getDescription() + ", with Soy";
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return Soy_beverage.cost() + .99;
	}

}
