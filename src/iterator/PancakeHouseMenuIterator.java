package iterator;

import java.util.ArrayList;

public class PancakeHouseMenuIterator implements Iterator {
	ArrayList<MenuItem> items;
	int position = 0;
 
	public PancakeHouseMenuIterator(ArrayList<MenuItem> items) {
		this.items = items;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (position >= items.size()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		MenuItem item = items.get(position);
		position = position + 1;
		return item;
	}

}

