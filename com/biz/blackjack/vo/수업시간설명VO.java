package com.biz.blackjack.vo;

public class 수업시간설명VO {

	private String suit;
	private String denomination;
	private int value;
	String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "수업시간설명VO [suit=" + suit + ", denomination=" + denomination + ", value=" + value + "]";
	}
	
}
