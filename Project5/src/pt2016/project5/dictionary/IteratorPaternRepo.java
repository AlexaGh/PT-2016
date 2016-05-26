package pt2016.project5.dictionary;

import java.io.Serializable;
import java.util.ArrayList;

public class IteratorPaternRepo implements Container, Serializable {

	private ArrayList<String> values = new ArrayList<String>();

	@Override
	public Iterator getIterator(ArrayList<String> values) {
		this.values= values;
		return new NameIterator();
	}

	private class NameIterator implements Iterator {

		int index;

		@Override
		public boolean hasNext() {
			if (index < values.size()) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if (this.hasNext()) {
				return values.get(index++);
			}
			return null;
		}

		@Override
		public int getIndex() {
			return index;
		}
	}

}
