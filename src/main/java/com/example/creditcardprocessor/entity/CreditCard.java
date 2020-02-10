package com.example.creditcardprocessor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String number;
    private Integer balance;

    public CreditCard(){}

    public CreditCard(String name, String number, Integer balance) {
        this.name = name;
        this.number = number;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public Integer getBalance() {
        return balance;
    }
}
