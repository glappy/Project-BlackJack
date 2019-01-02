package com.biz.blackjack.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.biz.blackjack.vo.BlackJackVO;

public class BlackJackService {

	List<BlackJackVO> cList;
	List<BlackJackVO> sList;
	BlackJackVO cvo;
	BlackJackVO svo;

	public BlackJackService() {
		cList = new ArrayList();
		sList = new ArrayList();
		cvo = new BlackJackVO();
		svo = new BlackJackVO();
	}

	public void cardList() {
		String[] s = { "Diamond ", "Spade ", "Heart ", "Club " };
		String[] ss = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q" };
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				BlackJackVO cvo = new BlackJackVO();
				cvo.setStrD(s[i] + ss[j]);
				cvo.setStrP(s[i] + ss[j]);
				cList.add(cvo);
				
			}

		}
	}

	public void scoreList() {
		int s[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
			
				BlackJackVO svo = new BlackJackVO();
				svo.setIntD(s[j]);
				svo.setIntP(s[j]);
				sList.add(svo);
			}
		}
		
	}

	public void shuffleDP() {
		
		for (BlackJackVO cvo : cList) {
			Collections.shuffle(cList);
			System.out.println(cvo);
		}
		System.out.println("------------------");
		for (BlackJackVO svo : sList) {
			Collections.shuffle(sList);
			System.out.println(svo);
		}
	}

	public void game() {
		String cardD = cList.get(1).getStrD() + "," + cList.get(2).getStrD();
		String cardP = cList.get(1).getStrP() + "," + cList.get(2).getStrP();
		int scoreD = sList.get(1).getIntD() + sList.get(2).getIntD();
		int scoreP = sList.get(1).getIntP() + sList.get(2).getIntP();

		System.out.printf("귀하와 플레이어는 두 장의 카드를 뽑았습니다. 두 사람의 카드는 각 %s, %s입니다.\n", cardD, cardP);
		System.out.printf("귀하와 플레이어 점수는 각 %d, %d입니다.\n", scoreD, scoreP);

		if (scoreD < 17) {
			scoreD += sList.get(3).getIntD();
			System.out.println("귀하의 점수가 17점 미만이므로 하나의 카드를 추가합니다.");
			System.out.printf("귀하의 세번째 카드는 %s이며 이제 총합은 %d입니다.\n", cardD, scoreD);
		}
		
		
		
		
	}
}
