package vn.hn.quanghuy.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vn.hn.quanghuy.model.Card;
import vn.hn.quanghuy.model.TYPE;

public final class CaculateUtil {

	private static final short N = 5;
	private static final short K = 3;

	private static boolean isFinish = false;

	private static List<HashMap<Card, Boolean>> currentListCard;
	private static List<Card> listOriginalCard;
	private static short[] existCard;

	/**
	 * Date: 2016/06/19 Author: Quang Huy Description: Private contructor,
	 * Utilities class
	 * 
	 */
	private CaculateUtil() {
	}

	public static List<HashMap<Card, Boolean>> getListCardSum10(List<Card> listCard) {

		initIsChooseCard();

		initOriginalCard(listCard);

		initListCurrentCard(listCard);

		if (checkDiamonds369()) {

			findTheBestPoint1();
		} else {

			findTheBestPoint2();
		}

		return currentListCard;
	}

	private static void initIsChooseCard() {

		existCard = new short[K];

		for (short i = 0; i < K; i++) {
			existCard[i] = (short) (i + 1);
		}
	}

	private static void initOriginalCard(List<Card> listCard) {

		listOriginalCard = new ArrayList<>(listCard);
	}

	private static void initListCurrentCard(List<Card> listCard) {

		currentListCard = new ArrayList<>();
		int size = listCard.size();

		HashMap<Card, Boolean> map = null;

		for (int i = 0; i < size; i++) {

			map = new HashMap<>();
			map.put(listCard.get(i), false);

			currentListCard.add(map);
		}

	}

	private static void findTheBestPoint1() {

		do {
			short point = 0;
			for (int i = 0; i < K; i++) {

				int position = existCard[i];
				point += listOriginalCard.get(position).getValue();
			}

			// generate
			nextCombination();
		} while (!isFinish);

	}

	private static void findTheBestPoint2() {

		short max = -1;

		do {
			short point = 0;
			Card card = null;
			HashMap<Card, Boolean> map = null;
			List<Card> tempList = new ArrayList<Card>();
			List<Card> existCardList = new ArrayList<Card>(listOriginalCard);

			for (int i = 0; i < K; i++) {

				int position = existCard[i];
				card = listOriginalCard.get(position - 1);
				point += card.getValue();
				tempList.add(card);

				// remove card
				existCardList.remove(card);
			}

			short tempOfMax = 0;
			for (Card c : existCardList) {

				tempOfMax += c.getValue();
			}

			if (mod10(point) && remainerOf10(tempOfMax) > max) {

				currentListCard.removeAll(currentListCard);

				for (Card c : tempList) {
					map = new HashMap<Card, Boolean>();
					map.put(c, true);
					currentListCard.add(map);
				}

				for (Card c : existCardList) {
					map = new HashMap<Card, Boolean>();
					map.put(c, false);
					currentListCard.add(map);
				}

				max = remainerOf10(tempOfMax);
				tempList.removeAll(tempList);
			}

			try {
				// generate
				nextCombination();
			} catch (Exception e) {
				// Finish Generate
			}

		} while (!isFinish);

	}

	private static boolean checkDiamonds369() {

		int size = listOriginalCard.size();

		for (int i = 0; i < N && size == N; i++) {
			Card card = listOriginalCard.get(i);
			if (card.getType().equals(TYPE.DIAMONDS) && null != card) {

				if (card.getValue() == 3 || card.getValue() == 6 || card.getValue() == 9) {
					return true;
				}
			}
		}
		return false;
	}

	private static void nextCombination() {

		short i, j;
		i = K;
		while (i >= 0 && existCard[i - 1] == N - K + i)
			i--;

		if (i >= 0) {
			existCard[i - 1] = (short) (existCard[i - 1] + 1);
			for (j = (short) (i - 1 + 1); j < K; j++) {
				existCard[j] = (short) (existCard[i - 1] + j - (i - 1));
			}
		} else {
			isFinish = true;
		}
	}

	private static boolean mod10(short point) {

		if (point % 10 == 0) {
			return true;
		}
		return false;
	}

	private static short remainerOf10(short value) {

		return (value != 10) ? (short) (value % 10) : value;

	}

}
