package singleton;

public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	
	private static ChocolateBoiler uniqueInstance;
	
	private ChocolateBoiler(){
		empty = true;
		boiled = false;
	}
	
	public static ChocolateBoiler getInstance(){
		if (uniqueInstance == null){
			return new ChocolateBoiler();
		}
		return uniqueInstance;
	}
	
	public void fill(){
		if (isEmpty()){
			empty = false;
			boiled = false;
			System.out.println("Start to filling......");
		}
	}
	
	public void boil(){
		if (!isEmpty() && !isBoiled()){
			boiled = true;
			System.out.println("Start to boiling......");
		}
	}
	
	public void drain(){
		if (!isEmpty() && isBoiled()){
			empty = true;
			boiled = false;
		}
	}
	
	public boolean isEmpty(){
		return empty;
	}
	
	public boolean isBoiled(){
		return boiled;
	}
}
