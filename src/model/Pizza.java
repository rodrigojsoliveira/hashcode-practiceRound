package model;

public class Pizza {
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
}
