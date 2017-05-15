package compound;

public class GooseAdapter implements Quackable{
	Goose goose;
	public GooseAdapter(Goose goose){
		this.goose = goose;
	}
	
	@Override
	public void quack() {
		// TODO Auto-generated method stub
		goose.honk();
	}

}
