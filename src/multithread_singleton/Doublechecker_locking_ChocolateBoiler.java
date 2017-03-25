package multithread_singleton;

public class Doublechecker_locking_ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	
	private volatile static Doublechecker_locking_ChocolateBoiler uniqueInstance;
	
	private Doublechecker_locking_ChocolateBoiler(){
		empty = true;
		boiled = false;
	}
	
	public static Doublechecker_locking_ChocolateBoiler getInstance(){
		if (uniqueInstance == null){
			synchronized (Doublechecker_locking_ChocolateBoiler.class){
				if (uniqueInstance == null){
					uniqueInstance = new Doublechecker_locking_ChocolateBoiler();
				}
			}
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

