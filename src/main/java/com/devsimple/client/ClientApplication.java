package com.devsimple.client;

import com.devsimple.client.facade.CallCenter;
import com.devsimple.client.model.Card;

public class ClientApplication {
	public static void main(String[] args) {

		CallCenter facade = new CallCenter();

		Card card = facade.getCardByUser(123456L);
		System.out.println(card);

		facade.getSumary(card);

		facade.getPaymentInfoByCard(card);

		facade.cancelLastRegister(card);

		Card newCard = facade.getCardByUser(123456L);
		System.out.println(newCard);

	}
}


