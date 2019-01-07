package com.biz.blackjack.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.biz.blackjack.vo.수업시간설명VO;

public class 수업시간설명service {

	List<수업시간설명VO> deckList;
	String suit = "다이아몬드:하트:스페이드:클로버";
	String denomination = "A123456789KQJ";
	
	public 수업시간설명service() {
		deckList = new ArrayList();
	}
	
	public List<수업시간설명VO> getDeck(){
		return deckList;
	}
	
	public void makeDeck() {
		String[] suits = suit.split(":");
		String[] denoms = denomination.split("");
		
		for(String s: suits) {
			for(String d : denoms) {
				수업시간설명VO vo = new 수업시간설명VO();
				vo.setSuit(s);
				vo.setDenomination(d);
				
				int intValue = 0;
				try {
					intValue = Integer.valueOf(d);
					if(intValue == 0) intValue =10;
				} catch (Exception e) {
					// TODO: handle exception
					if(d.equals("A")) intValue =1;
					else {intValue =10;}
				}
				vo.setValue(intValue);
				deckList.add(vo);
				
				Collections.shuffle(deckList);
			}
		}
	}
}
