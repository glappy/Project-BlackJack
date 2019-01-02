package com.biz.blackjack.vo;

public class BlackJackVO {

	/*
	 * 블랙잭 게임을 하려고 한다 딜러와 플레이어가 게임을 하며 딜러가 맨 처음 두 장을 뽑았을 때 합이 17이 안되면 진다 계속 카드를 하나씩
	 * 추가하되 어느 한쪽의 합이 21이 넘어가면 패배하는 것으로 한다 에이스를 뽑으면 1점이 추가되는 것으로 한다
	 */
	private String strD;
	private String strP;
	/*
	 * d는 딜러, p를 플레이어를 말한다 딜러의 카드이름을 만들고 각 카드에 대한 점수를 부여하기 위해 vo를 만든다
	 */
	private int intD;	
	private int intP;
	public String getStrD() {
		return strD;
	}
	public void setStrD(String strD) {
		this.strD = strD;
	}
	public String getStrP() {
		return strP;
	}
	public void setStrP(String strP) {
		this.strP = strP;
	}
	public int getIntD() {
		return intD;
	}
	public void setIntD(int intD) {
		this.intD = intD;
	}
	public int getIntP() {
		return intP;
	}
	public void setIntP(int intP) {
		this.intP = intP;
	}
	
	@Override
	public String toString() {
		return "BlackJackVO [strD=" + strD + ", strP=" + strP + ", intD=" + intD + ", intP=" + intP + "]";
	}



}
