package com.example.borrow_book.repository;

import com.example.borrow_book.model.CodeRandom;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IRandomCodeRepository extends JpaRepository<CodeRandom,Integer> {
    CodeRandom findByCodeContaining(String number);
}
