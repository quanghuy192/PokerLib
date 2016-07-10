package vn.hn.quanghuy.model;

import java.awt.Window.Type;

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

	@Override
	public boolean equals(Object obj) {

		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Card)) {
			return false;
		}

		Card card = (Card) obj;
		return (card.value == value 
				&& card.isChoose == isChoose 
				&& card.type.ordinal() == type.ordinal());
	}

	@Override
	public int hashCode() {

		int result = 17;
		int valuesOfIsChoose = (isChoose ? 1 : 0);
		int valuesOfNumber = value;
		int valuesOfType;

		if (type.ordinal() == TYPE.DIAMONDS.ordinal()) {

			valuesOfType = 18;
		} else if (type.ordinal() == TYPE.HEARTS.ordinal()) {

			valuesOfType = 19;
		} else if (type.ordinal() == TYPE.SPADE.ordinal()) {

			valuesOfType = 23;
		} else if (type.ordinal() == TYPE.CLUBS.ordinal()) {

			valuesOfType = 29;
		} else {

			valuesOfType = 31;
		}

		result = 31 * result + valuesOfIsChoose;
		result = 31 * result + valuesOfNumber;
		result = 31 * result + valuesOfType;

		return result;
	}

}
