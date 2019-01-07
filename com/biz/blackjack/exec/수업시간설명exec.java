package com.biz.blackjack.exec;

import java.util.List;

import com.biz.blackjack.service.수업시간설명service;
import com.biz.blackjack.vo.수업시간설명VO;

public class 수업시간설명exec {

	public static void main(String[] args) {
		수업시간설명service bs = new 수업시간설명service();
		bs.makeDeck();
		
		List<수업시간설명VO> deckList = bs.getDeck();
	}
}
