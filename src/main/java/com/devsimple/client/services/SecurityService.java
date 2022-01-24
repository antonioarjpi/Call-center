package com.devsimple.client.services;

import com.devsimple.client.model.Card;
import com.devsimple.client.model.Register;

import java.util.List;

public class SecurityService {

    private CardService cardService;
    private RegisterService registerService;

    public SecurityService(CardService cardService, RegisterService registerService) {
        this.cardService = cardService;
        this.registerService = registerService;
    }

    public List<Register> blockCard(Card card) {
        System.out.println("Bloqueando cartão:" + card);
        List<Register> pendingRegistries = registerService.getRegistersByCard(card);
        cardService.removeCard(card);
        registerService.deleteCardRegistries(card);
        return pendingRegistries;
    }
}
