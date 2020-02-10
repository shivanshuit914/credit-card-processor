package com.example.creditcardprocessor.controller;

import com.example.creditcardprocessor.entity.CreditCard;
import com.example.creditcardprocessor.service.CreditCardService;
import com.example.creditcardprocessor.validator.LuhnValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit-card")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private LuhnValidator luhnValidator;

    @PostMapping("")
    public ResponseEntity createCreditCard(@RequestBody CreditCardDTO requestBody) {
        if (!luhnValidator.validate(requestBody.getNumber())) {
            return ResponseEntity.badRequest().body("Invalid card number");
        }
        CreditCard creditCard = creditCardService.addCreditCard(
            requestBody.getName(),
            requestBody.getNumber(),
            requestBody.getBalance()
        );
        return ResponseEntity.accepted().body(creditCard);
    }

    @GetMapping("")
    public ResponseEntity<List<CreditCard>> getCreditCards() {
        return ResponseEntity.accepted().body(creditCardService.getCards());
    }
}