package com.biz.blackjack.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.biz.blackjack.vo.AccVO;
import com.biz.blackjack.vo.CardVO;

public class BlackJackService {

	List<CardVO> cList;// 리스트 선언
	List<AccVO> aList;

	CardVO cvo;
	AccVO avo;
	Scanner scan;

	public BlackJackService() {
		cList = new ArrayList(); // 리스트와 vo 초기화시켜주기
		cvo = new CardVO();
		aList = new ArrayList();
		avo = new AccVO();
	}

	public void cardName() {
		String[] cName1 = { "Diamond ", "Spade ", "Heart ", "Club " };
		String[] cName2 = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q" };
		int cScore[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };

		/*
		 * 카드 만들어 리스트에 담기
		 * 
		 */
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
		/*
		 * 카드 순서를 섞기 위해 shuffle사용
		 */
		for (CardVO cvo : cList) {
			Collections.shuffle(cList);
		}
	}

	public void accumulated() {
		/*
		 * 다른 메서드에서 String과 int를 반복적으로 쓰지 않기 위해 리스트에 shuffle된 카드를 누적으로 담음
		 */
		
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
		
		/*
		 * dealer           /           player
		 * 카드1, 점수1
		 * 								카드1, 점수
		 * 카드12, 점수12
		 * 								카드12, 점수12
		 * 카드123, 점수123
		 * 								카드123, 점수123
		 */
		
	}

	public void gameStart() {
		/*
		 * 키보드로 입력받아 카드를 보여주는 단계
		 * acclist에서 각 2,3번째를 불러온다
		 * 1을 입력하면 seventeen(); method로 이동
		 * 그 외 값을 입력하면 1을 입력하도록 유도
		 * 
		 * 
		 * 두 사람이 두장씩 뽑음
		 * 딜러 합이 17미만이면 딜러가 한번 더 뽑고 점수 비교해서 승자를 가림
		 */
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
		
		/*
		 * gameStart method에서 받은 값을 가지고 실행
		 * 뽑은 값의 합이 17이 안되면 2를 눌러 한장을 다시 뽑게 하고 tOne method 실행
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
					break ;
				}
				System.out.println("카드를 뽑으려면 2를 누르세요.");

			} else {
				tOne();
				return;
			}
		}
	}

	public void tOne() {

		/*
		 * String dCards = dList.get(0).getStrD() + ", " + dList.get(1).getStrD();
		 * String pCards = pList.get(0).getStrP() + ", " + pList.get(1).getStrP(); 
		 * int dTotal = dList.get(0).getIntD() + dList.get(1).getIntD(); 
		 * int pTotal = pList.get(0).getIntP() + pList.get(1).getIntP();
		 */

		/*
		 * seventeen method에서 받은 결과를 가지고 검사.
		 * gamestart와 seventeen method에서 받은 값을 토대로 17~21점이면 카드추가를, 그렇지 않으면 승패를 알림.
		 */
		String strThird = aList.get(4).getStrAccD();
		int intThird = aList.get(4).getIntAccD();

		for (AccVO avo : aList) {

			if (intThird >= 17 && intThird <= 21) {
				System.out.println("두 사람의 점수가 21점 이하이므로 카드를 계속해서 뽑습니다.");
				System.out.printf("귀하와 플레이어의 카드는 각 %s, %d / %s, %d입니다.\n", aList.get(4).getStrAccD(),
						aList.get(4).getIntAccD(), aList.get(5).getStrAccP(), aList.get(5).getIntAccP());
				break;
			} else if (aList.get(5).getIntAccD() > 21 || aList.get(5).getIntAccP() > 21) {
				System.out.printf("두 사람의 점수가 각 %d와 %d이므로 게임을 종료합니다.\n", aList.get(4).getIntAccD(),
						aList.get(5).getIntAccP());
				break ;
			}

		}
	}

}
