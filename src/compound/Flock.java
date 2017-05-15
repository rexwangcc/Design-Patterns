package compound;

import java.util.ArrayList;
import java.util.Iterator;

public class Flock implements Quackable {
	ArrayList<Quackable> quackers = new ArrayList<Quackable>();
	
	@Override
	public void quack() {
		// TODO Auto-generated method stub
		Iterator<Quackable> iterator = quackers.iterator();
		while(iterator.hasNext()){
			Quackable quacker = (Quackable)iterator.next();
			quacker.quack();
		}
	}
	
	public void add(Quackable quacker){
		quackers.add(quacker);
	}

}
