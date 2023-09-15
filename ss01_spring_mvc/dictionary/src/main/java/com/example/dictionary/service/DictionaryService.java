package com.example.dictionary.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService {
    public Map<String,String> mapDictionary(){
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("dog", "chó");
        dictionary.put("cat", "mèo");
        dictionary.put("bike", "xe đạp");
        dictionary.put("Math", "môn toán");
        return dictionary;
    }
}

