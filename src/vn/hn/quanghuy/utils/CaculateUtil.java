package vn.hn.quanghuy.utils;

import java.util.ArrayList;
import java.util.List;

import vn.hn.quanghuy.model.Card;

public final class CaculateUtil {

	private static final short N = 5;
	private static final short K = 3;

	private static boolean isFinish = false;

	private static List<Card> currentListCard;
	private static short[] existCard;

	/**
	 * Date: 2016/06/19 Author: Quang Huy Description: Private contructor,
	 * Utilities class
	 * 
	 */
	private CaculateUtil() {
	}

	public static List<Card> getListCardSum10(List<Card> listCard) {

		initExistCard();
		
		checkDiamonds369();
		
		while(!isFinish){
			
			short point = 0;
			for (int i = 0; i < N; i++) {
				
				int position = existCard[i];
				point += currentListCard.get(position).getValue();
			}
			
		}

		currentListCard = new ArrayList<>(listCard);
		return currentListCard;
	}

	private static void checkDiamonds369() {

	}

	private static void nextCombination() {

		short i, j;
		i = K;
		while (i > 0 && existCard[i] == N - K + i)
			i--;

		if (i > 0) {

			existCard[i] = (short) (existCard[i] + 1);
			for (j = (short) (i + 1); j <= K; j++) {

				existCard[j] = (short) (existCard[i] + j - i);
			}
		} else {

			isFinish = true;
		}

	}

	private static void initExistCard() {

		existCard = new short[K];

		for (short i = 0; i < K; i++) {
			existCard[i] = i;
		}
	}

	private static boolean mod10(short point) {

		if (point % 10 == 0) {
			return true;
		}
		return false;
	}

}
