package decorator;

public class DarkRoast extends Beverage{
	
	public DarkRoast(){
		description = "Dark Roast Coffee";
	}
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 4.99;
	}
	

}
