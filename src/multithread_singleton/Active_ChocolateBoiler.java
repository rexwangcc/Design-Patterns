package multithread_singleton;

public class Active_ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	
	private static Active_ChocolateBoiler uniqueInstance = new Active_ChocolateBoiler();
	
	private Active_ChocolateBoiler(){
		empty = true;
		boiled = false;
	}
	
	public static Active_ChocolateBoiler getInstance(){
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

