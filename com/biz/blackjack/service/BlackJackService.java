package com.biz.blackjack.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.biz.blackjack.vo.BlackJackVO_01;
import com.biz.blackjack.vo.BlackJackVO_02;

public class BlackJackService {

	List<BlackJackVO_01> dList;
	List<BlackJackVO_02> pList;
	
	BlackJackVO_01 dvo;
	BlackJackVO_02 pvo;

	Scanner scan;

	public BlackJackService() {
		dList = new ArrayList();
		pList = new ArrayList();
	
		dvo = new BlackJackVO_01();
		pvo = new BlackJackVO_02();
	}

	public void dList() {
		String[] dName1 = { "Diamond ", "Spade ", "Heart ", "Club " };
		String[] dName2 = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q" };
		int dScore[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {

				dvo = new BlackJackVO_01();
				dvo.setStrD(dName1[i] + dName2[j]);
				dvo.setIntD(dScore[j]);

				dList.add(dvo);

			}

		}

	}

	public void pList() {

		String[] pName1 = { "Diamond ", "Spade ", "Heart ", "Club " };
		String[] pName2 = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q" };
		int pScore[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				pvo = new BlackJackVO_02();
				pvo.setStrP(pName1[i] + pName2[j]);
				pvo.setIntP(pScore[j]);
				pList.add(pvo);
			}

		}

	}

	public void shuffleDP() {

		for (BlackJackVO_01 dvo : dList) {
			Collections.shuffle(dList);
		}
		for (BlackJackVO_02 pvo : pList) {
			Collections.shuffle(pList);
		}

	}

	
	public void gameStart() {
		System.out.println("귀하는 현재 딜러입니다.");
		System.out.println("카드를 선택하고 뽑으려면 1을 눌러주세요");

		String dCards = dList.get(0).getStrD() + ", " + dList.get(1).getStrD();
		String pCards = pList.get(0).getStrP() + ", " + pList.get(1).getStrP();
		int dTotal = dList.get(0).getIntD() + dList.get(1).getIntD();
		int pTotal = pList.get(0).getIntP() + pList.get(1).getIntP();

		while (true) {
			scan = new Scanner(System.in);
			String chosen = scan.nextLine();
			int intChosen = Integer.valueOf(chosen);

			if (intChosen == 1) {
				System.out.printf("귀하 : %s / %d점. 플레이어 : %s / %d점\n", dCards, dTotal, pCards, pTotal);
				seventeen();
				return;
			} else {
				System.out.println("카드를 뽑으려면 1을 눌러주세요");
			}

		}

	}

	public void seventeen() {
		String dCards = dList.get(0).getStrD() + ", " + dList.get(1).getStrD();
		String pCards = pList.get(0).getStrP() + ", " + pList.get(1).getStrP();
		int dTotal = dList.get(0).getIntD() + dList.get(1).getIntD();
		int pTotal = pList.get(0).getIntP() + pList.get(1).getIntP();
		

		if (dTotal < 17) {
			System.out.printf("귀하의 점수가 %d이므로 한장을 다시 뽑습니다.\n", dTotal);
		}

		while (true) {
			scan = new Scanner(System.in);
			System.out.println("카드를 뽑으려면 2를 눌러주세요");
			String two = scan.nextLine();
			int intTwo = Integer.valueOf(two);
			if (intTwo == 2) {
				tOne();
				break;
			}
			System.out.println("카드를 뽑으려면 2를 누르세요.");
			
		}
	}

	public void tOne() {
		
		String dCards = dList.get(0).getStrD() + ", " + dList.get(1).getStrD();
		String pCards = pList.get(0).getStrP() + ", " + pList.get(1).getStrP();
		int dTotal = dList.get(0).getIntD() + dList.get(1).getIntD();
		int pTotal = pList.get(0).getIntP() + pList.get(1).getIntP();


		dTotal += dList.get(2).getIntD();
		System.out.printf("귀하가 뽑은 카드는 %s이며 현재 점수는 %d입니다.\n", dList.get(2).getStrD(), dTotal);
		
		for (BlackJackVO_01 dvo : dList) {
			
			
			if (dTotal >= 17 && dTotal <= 21) {
				System.out.println("두 사람의 점수가 21점 이하이므로 카드를 계속해서 뽑습니다.");
				System.out.printf("귀하와 플레이어의 카드는 각 %s, %s입니다.\n", dList.get(2).getStrD(), pList.get(2).getStrP());
				break;
			}

			if (dTotal > 21 || pTotal > 21) {
				System.out.printf("두 사람의 점수가 각 %d와 %d이므로 게임을 종료합니다.\n", dTotal, pTotal);
				break;
			}			

		}
	}
}
