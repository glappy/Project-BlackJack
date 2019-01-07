package com.biz.blackjack.vo;

public class AccVO {

	String strAccD;
	int intAccD;
	String strAccP;
	int intAccP;
	public String getStrAccD() {
		return strAccD;
	}
	public void setStrAccD(String strAccD) {
		this.strAccD = strAccD;
	}
	public int getIntAccD() {
		return intAccD;
	}
	public void setIntAccD(int intAccD) {
		this.intAccD = intAccD;
	}
	public String getStrAccP() {
		return strAccP;
	}
	public void setStrAccP(String strAccP) {
		this.strAccP = strAccP;
	}
	public int getIntAccP() {
		return intAccP;
	}
	public void setIntAccP(int intAccP) {
		this.intAccP = intAccP;
	}
	@Override
	public String toString() {
		return "AccVO [strAccD=" + strAccD + ", intAccD=" + intAccD + ", strAccP=" + strAccP
				+ ", intAccP=" + intAccP + "]";
	}
	
	
}
