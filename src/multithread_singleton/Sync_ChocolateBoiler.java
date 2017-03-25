package multithread_singleton;

public class Sync_ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	
	private static Sync_ChocolateBoiler uniqueInstance;
	
	private Sync_ChocolateBoiler(){
		empty = true;
		boiled = false;
	}
	
	public static synchronized Sync_ChocolateBoiler getInstance(){
		if (uniqueInstance == null){
			return new Sync_ChocolateBoiler();
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
