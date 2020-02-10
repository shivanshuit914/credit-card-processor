package com.example.creditcardprocessor.service;

import com.example.creditcardprocessor.entity.CreditCard;
import com.example.creditcardprocessor.repository.CreditCardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardServiceTest {

    @InjectMocks
    private CreditCardService creditCardService;

    @Mock
    private CreditCardRepository creditCardRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAllCreditCards() {
        List<CreditCard> expectedCards = Arrays.asList(
                new CreditCard("test", "12324234", 0),
                new CreditCard("test2", "123242343", 0)
        );
        Mockito.when(creditCardRepository.findAll()).thenReturn(expectedCards);
        List<CreditCard> cards = creditCardService.getCards();
        assertEquals(cards, expectedCards);
    }

    @Test
    public void addCreditCard() {
        CreditCard card = creditCardService.addCreditCard("test", "12324234", 0);
        Mockito.verify(creditCardRepository).save(card);
    }
}