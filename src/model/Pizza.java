package model;

public class Pizza implements Comparable<Pizza>{
	
	private int type;
	private int size;

	public Pizza(int type, int size) {
		super();
		this.type = type;
		this.size = size;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int compareTo(Pizza o) {
		if (this.type == o.type) {
			return 0;
		} else if (this.type > o.type) {
			return 1;
		} else {
			return -1;
		}
	}

	
}
