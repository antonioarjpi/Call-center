package com.devsimple.client.facade;

import com.devsimple.client.model.Card;
import com.devsimple.client.model.Register;
import com.devsimple.client.services.*;

import java.util.List;

public class CallCenter {

    CardService cardService;
    RegisterService registerService;
    ReportService reportService;
    PaymentService paymentService;
    SecurityService securityService;

    public CallCenter(){
        cardService = new CardService();
        registerService = new RegisterService();
        reportService = new ReportService(registerService);
        paymentService = new PaymentService(registerService);
        securityService = new SecurityService(cardService, registerService);
    }


    public Card getCardByUser(Long card){
        return cardService.getCardByUser(card);
    }

    public void getSumary(Card card){
        reportService.getSumary(card);
    }

    public void getPaymentInfoByCard(Card card){
        paymentService.getPaymentInfoByCard(card);
    }

    public void cancelLastRegister(Card card) {
        List<Register> registers = registerService.getRegistersByCard(card);
        registerService.removeByIndex(card, registers.size() - 1);
        List<Register> pendingRegisters = securityService.blockCard(card);
        Card newCard = cardService.createNewCard(123456L, 33445566L);
        registerService.addCardRegisters(newCard, pendingRegisters);
        reportService.getSumary(newCard);
    }
}
