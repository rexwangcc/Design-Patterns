package state;

public class WinnerState implements State {
	GumballMachine gumballMachine;
	
	public WinnerState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}
	@Override
	public void insertQuarter() {
		// TODO Auto-generated method stub
		System.out.println("Wait, we've already giving you a gumball!!");
	}

	@Override
	public void ejectQuarter() {
		// TODO Auto-generated method stub
		System.out.println("You have turned the crank!!");
	}

	@Override
	public void turnCrank() {
		// TODO Auto-generated method stub
		System.out.println("Turning the crank twice won't get you another gumball!");
	}

	@Override
	public void dispense() {
		// TODO Auto-generated method stub
		System.out.println("You are a WINNER!! You get 2 gumballs for your quarter!");
		gumballMachine.relaeseBall();
		if(gumballMachine.getCount() == 0){
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}else{
			gumballMachine.relaeseBall();
			if(gumballMachine.getCount() > 0){
				gumballMachine.setState(gumballMachine.getNoQuarterState());
			}else{
				System.out.println("Oops, out of gumballs!");
				gumballMachine.setState(gumballMachine.getSoldOutState());
			}
		}
	}

}
