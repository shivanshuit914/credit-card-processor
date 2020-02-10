package com.example.creditcardprocessor.repository;

import com.example.creditcardprocessor.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
