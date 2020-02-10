package com.example.creditcardprocessor.service;

import com.example.creditcardprocessor.entity.CreditCard;
import com.example.creditcardprocessor.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    public CreditCard addCreditCard(String name, String number, Integer balance) {
        CreditCard creditCard = new CreditCard(name, number, balance);
        creditCardRepository.save(creditCard);
        return creditCard;
    }

    public List<CreditCard> getCards() {
        return creditCardRepository.findAll();
    }
}
