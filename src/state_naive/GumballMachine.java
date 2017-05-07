package state_naive;

public class GumballMachine {
	final static int SOLD_OUT = 0;
	final static int NO_QUARTER = 1;
	final static int HAS_QUARTER = 2;
	final static int SOLD = 3;
	
	// Initial state set to no Gumballs
	int state = SOLD_OUT;
	int count = 0;
	
	public GumballMachine(int count){
		this.count = count;
		if(count>0){
			state = NO_QUARTER;
		}
	}
	
	public void insertQuarter(){
		if(state == HAS_QUARTER){
			System.out.println("You cannot insert another quarter!");
		}else if(state == NO_QUARTER){
			state = HAS_QUARTER;
			System.out.println("Successfully inserted a quarter!");
		}else if(state == SOLD_OUT){
			System.out.println("Cannot insert quarters, already sold out all of Gumballs..");
		}else if(state == SOLD){
			System.out.println("Please wait, we already giving you a gumball!");
		}
	}
	
	public void ejectQuarter(){
		if(state == HAS_QUARTER){
			System.out.println("Successfully returned your quarter!");
		}else if(state == NO_QUARTER){
			System.out.println("You haven't inserted any quarters!");
		}else if(state == SOLD){
			System.out.println("Sorry, you already turned the crank!");
		}else if(state == SOLD_OUT){
			System.out.println("Can't eject, you haven't inserted any quarters!");
		}
	}
	
	public void turnCrank(){
		if(state == SOLD){
			System.out.println("You cannot get another gumball!");
		}else if(state == NO_QUARTER){
			System.out.println("You turned but there's no quarter!");
		}else if(state == SOLD_OUT){
			System.out.println("Sorry, we have sold out all gumballs...");
		}else if(state == HAS_QUARTER){
			System.out.println("You turned......");
			state = SOLD;
			dispense();
		}
	}
	
	public void dispense(){
		if(state == SOLD){
			System.out.println("A gumball is coming out from the slot!!!");
			count = count - 1;
			if(count ==0){
				System.out.println("Opps, out of gumballs!");
				state = SOLD_OUT;
			}else{
				state = NO_QUARTER;
			}
		}else if(state == NO_QUARTER){
			// Would never happen though
			System.out.println("You need to pay first!");
		}else if(state == SOLD_OUT){
			// Would never happen though
			System.out.println("No gumball dispensed");
		}else if(state == HAS_QUARTER){
			// Would never happen though
			System.out.println("No gumball dispensed");
		}
	}
	
	public String toString(){
		return "=========================\n"+"Rex Brand Gumball Machine #2017\n" + "Inventory: " + Integer.toString(this.count) + " gumballs\n";
	}
}
