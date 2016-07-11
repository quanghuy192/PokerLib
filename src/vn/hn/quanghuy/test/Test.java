package vn.hn.quanghuy.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vn.hn.quanghuy.model.Card;
import vn.hn.quanghuy.model.TYPE;
import vn.hn.quanghuy.utils.CaculateUtil;

public class Test {

    public static void main(String[] args) {
    	
    	List<Card> list = new ArrayList<Card>();
    	list.add(new Card((short) 1, TYPE.HEARTS));
    	list.add(new Card((short) 3, TYPE.CLUBS));
    	list.add(new Card((short) 4, TYPE.HEARTS));
    	list.add(new Card((short) 6, TYPE.HEARTS));
    	list.add(new Card((short) 7, TYPE.DIAMONDS));
    	
    	List<HashMap<Card, Boolean>> testList = CaculateUtil.getListCardSum10(list);
    	for (HashMap<Card, Boolean> hashMap : testList) {
			System.out.println(hashMap.keySet());
			System.out.println(hashMap.get(hashMap.keySet()));
		}
    }

}
