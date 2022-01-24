package com.devsimple.client.services;

import com.devsimple.client.model.Card;
import com.devsimple.client.model.Register;

import java.util.List;

public class PaymentService {

    private RegisterService registerService;

    public PaymentService(RegisterService registerService) {
        this.registerService = registerService;
    }

    public void getPaymentInfoByCard(Card card) {
        List<Register> registers = registerService.getRegistersByCard(card);
        double sum = registers.stream()
                .reduce(0d, (partialValue, reg) -> partialValue + reg.getValue(), Double::sum);
        System.out.println(String.format("Você tem que pagar %.2f até a próxima semana", sum));
    }
}
