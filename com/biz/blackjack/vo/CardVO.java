package com.biz.blackjack.vo;

public class CardVO {

	private String strC;
	private int intC;
	
	public String getStrC() {
		return strC;
	}
	public void setStrC(String strC) {
		this.strC = strC;
	}
	public int getIntC() {
		return intC;
	}
	public void setIntC(int intC) {
		this.intC = intC;
	}
	@Override
	public String toString() {
		return "CardVO [strC=" + strC + ", intC=" + intC + "]";
	}	
	
	

}
