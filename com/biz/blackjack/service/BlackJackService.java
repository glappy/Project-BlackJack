package com.biz.blackjack.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.biz.blackjack.vo.AccVO;
import com.biz.blackjack.vo.CardVO;

public class BlackJackService {

	List<CardVO> cList;
	List<AccVO> aList;

	CardVO cvo;
	AccVO avo;
	Scanner scan;

	public BlackJackService() {
		cList = new ArrayList();
		cvo = new CardVO();
		aList = new ArrayList();
		avo = new AccVO();
	}

	public void cardName() {
		String[] cName1 = { "Diamond ", "Spade ", "Heart ", "Club " };
		String[] cName2 = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q" };
		int cScore[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {

				cvo = new CardVO();
				cvo.setStrC(cName1[i] + cName2[j]);
				cvo.setIntC(cScore[j]);
				cList.add(cvo);

			}

		}
	}

	public void shuffleDP() {

		for (CardVO cvo : cList) {
			Collections.shuffle(cList);
		}
	}

	public void accumulated() {
		String aDo = "";
		int aDt = 0;
		String aPo = "";
		int aPt = 0;

		int size = (cList.size());
		for (int i = 0; i < size; i++) {
			avo = new AccVO();

			if (i % 2 == 0) {
				aDo += cList.get(i).getStrC() + ", ";
				aDt += cList.get(i).getIntC();
				avo.setStrAccD(aDo);
				avo.setIntAccD(aDt);
				aList.add(avo);
			}
//			aDo += cList.get(i*2).getStrC() + ", ";
//			aDt += cList.get(i*2).getIntC();
//			avo.setStrAccD(aDo);
//			avo.setIntAccD(aDt);
			else {
				aPo += cList.get(i).getStrC() + ", ";
				aPt += cList.get(i).getIntC();
				avo.setStrAccP(aPo);
				avo.setIntAccP(aPt);
				aList.add(avo);

			}
//			aPo += cList.get((i*2)+1).getStrC() + ", ";
//			aPt += cList.get((i*2)+1).getIntC();
//			avo.setStrAccP(aPo);
//			avo.setIntAccP(aPt);
//			aList.add(avo);

		}

	}

	public void gameStart() {
		System.out.println("귀하는 현재 딜러입니다.");
		System.out.println("카드를 선택하고 뽑으려면 1을 눌러주세요");

		while (true) {
			scan = new Scanner(System.in);
			String chosen = scan.nextLine();
			int intChosen = Integer.valueOf(chosen);

			if (intChosen == 1) {
				System.out.printf("귀하 : %s / %d점. 플레이어 : %s / %d점\n", aList.get(2).getStrAccD(),
						aList.get(2).getIntAccD(), aList.get(3).getStrAccP(), aList.get(3).getIntAccP());
				seventeen();
				return;
			} else {
				System.out.println("카드를 뽑으려면 1을 눌러주세요");
			}

		}

	}

	public void seventeen() {
		/*
		 * String dCards = dList.get(0).getStrD() + ", " + dList.get(1).getStrD();
		 * String pCards = pList.get(0).getStrP() + ", " + pList.get(1).getStrP(); int
		 * dTotal = dList.get(0).getIntD() + dList.get(1).getIntD(); int pTotal =
		 * pList.get(0).getIntP() + pList.get(1).getIntP();
		 */

		while (true) {
			if (aList.get(2).getIntAccD() < 17) {
				System.out.printf("귀하의 점수가 %d이므로 한장을 다시 뽑습니다.\n", aList.get(2).getIntAccD());
	

				scan = new Scanner(System.in);
				System.out.println("카드를 뽑으려면 2를 눌러주세요");
				String two = scan.nextLine();
				int intTwo = Integer.valueOf(two);
				if (intTwo == 2) {
					System.out.printf("귀하가 뽑은 카드는 %s이며 현재 점수는 %d입니다.\n", aList.get(4).getStrAccD(),
							aList.get(4).getIntAccD());

					tOne();
					break;
				}
				System.out.println("카드를 뽑으려면 2를 누르세요.");

			}
		}
	}

	public void tOne() {

		/*
		 * String dCards = dList.get(0).getStrD() + ", " + dList.get(1).getStrD();
		 * String pCards = pList.get(0).getStrP() + ", " + pList.get(1).getStrP(); int
		 * dTotal = dList.get(0).getIntD() + dList.get(1).getIntD(); int pTotal =
		 * pList.get(0).getIntP() + pList.get(1).getIntP();
		 */

		String strThird = aList.get(4).getStrAccD();
		int intThird = aList.get(4).getIntAccD();

		for (AccVO avo : aList) {

			if (intThird >= 17 && intThird <= 21) {
				System.out.println("두 사람의 점수가 21점 이하이므로 카드를 계속해서 뽑습니다.");
				System.out.printf("귀하와 플레이어의 카드는 각 %s, %d, %s, %d입니다.\n", aList.get(4).getStrAccD(),
						aList.get(4).getIntAccD(), aList.get(5).getStrAccP(), aList.get(5).getIntAccP());
			}

			if (aList.get(5).getIntAccD() > 21 || aList.get(5).getIntAccP() > 21) {
				System.out.printf("두 사람의 점수가 각 %d와 %d이므로 게임을 종료합니다.\n", aList.get(5).getIntAccD(),
						aList.get(5).getIntAccP());
				break;
			}

		}
	}

}
