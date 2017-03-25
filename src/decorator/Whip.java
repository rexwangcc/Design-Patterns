package decorator;

public class Whip extends CondimentDecorator{
	Beverage Whip_beverage;
	public Whip(Beverage beverage){
		this.Whip_beverage = beverage;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return Whip_beverage.getDescription() + ", with Whip";
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return Whip_beverage.cost() + .3;
	}

}
