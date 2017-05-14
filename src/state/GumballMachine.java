package state;

public class GumballMachine {
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State winnerState;
	
	State state = soldOutState;
	int count = 0;
	
	public GumballMachine(int numberGumballs){
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);
		this.count = numberGumballs;
		
		if(numberGumballs > 0){
			state = noQuarterState;
		}
	}
	
	public void insertQuarter(){
		state.insertQuarter();
	}
	
	public void ejectQuarter(){
		state.ejectQuarter();
	}
	
	public void turnCrank(){
		state.turnCrank();
		state.dispense();
	}
	
	void setState(State state){
		this.state = state;
	}
	
	void relaeseBall(){
		System.out.println("A gumball comes rolling out the slot...");
		if(count != 0){
			count -= 1;
		}
	}
	
	public State getHasQuarterState(){
		return hasQuarterState;
	}
	
	public State getSoldOutState(){
		return soldOutState;
	}
	
	public State getNoQuarterState(){
		return noQuarterState;
	}
	
	public State getSoldState(){
		return soldState;
	}
	
	public State getWinnerState(){
		return winnerState;
	}
	
	public int getCount(){
		return count;
	}
	
	public String toString(){
		return "=========================\n"+"Rex Brand Gumball Machine #2017\n" + "Inventory: " + Integer.toString(this.count) + " gumballs\n";
	}
	
	
}
