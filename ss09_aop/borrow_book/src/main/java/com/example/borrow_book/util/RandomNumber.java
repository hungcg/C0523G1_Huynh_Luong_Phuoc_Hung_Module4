package com.example.borrow_book.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomNumber {

    public static List<Integer> generateRandomSequence() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers); // Trộn ngẫu nhiên danh sách số

        List<Integer> randomSequence = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            randomSequence.add(numbers.get(i));
        }
        return randomSequence;
    }
}
