package com.devsimple.client.services;

import com.devsimple.client.model.Card;
import com.devsimple.client.model.Register;

import java.util.*;

public class RegisterService {

    private Map<Long, List<Register>> memory;

    public RegisterService() {
        memory = new HashMap<Long, List<Register>>();
        memory.put(11223344L, new ArrayList<>(Arrays.asList(
                new Register("McDonalds", 15d, new Date()),
                new Register("Burguer King", 25d, new Date()),
                new Register("Subway", 50d, new Date())
        )));
    }

    public List<Register> getRegistersByCard(Card card) {
        return memory.get(card.getCardNumber());
    }

    public void removeByIndex(Card card, int i) {
        List<Register> list = memory.get(card.getCardNumber());
        Register reg = list.remove(i);
        System.out.println(reg.toString() + "Deletado!");
        memory.put(card.getCardNumber(), list);
    }

    public void deleteCardRegistries(Card card) {
        memory.remove(card.getCardNumber());
    }

    public void addCardRegisters(Card card, List<Register> registers) {
        System.out.println("Associando dados ao cartão!...");
        memory.put(card.getCardNumber(), registers);
    }
}
