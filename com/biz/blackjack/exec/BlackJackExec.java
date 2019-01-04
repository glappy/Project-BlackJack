package com.biz.blackjack.exec;

import com.biz.blackjack.service.BlackJackService;

public class BlackJackExec {

	public static void main(String[] args) {
		BlackJackService bjs = new BlackJackService();

		
		bjs.cardName();
		bjs.shuffleDP();
		bjs.accumulated();
		bjs.gameStart();
		bjs.seventeen();
		bjs.tOne();
		
	}
}
