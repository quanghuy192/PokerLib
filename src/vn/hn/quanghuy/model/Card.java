package vn.hn.quanghuy.model;

public class Card {

	private short value;
	private boolean isChoose;
	private TYPE type;

	public short getValue() {
		return value;
	}

	public void setValue(short value) {
		this.value = value;
	}

	public boolean isChoose() {
		return isChoose;
	}

	public void setChoose(boolean isChoose) {
		this.isChoose = isChoose;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

}
