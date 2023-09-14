package com.example.testovoezadanierestservicestringcounter.services;

import com.example.testovoezadanierestservicestringcounter.serializers.CustomMapSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class MainService {
    private ObjectMapper mapper;

    public MainService() {
        this.mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(TreeMap.class, new CustomMapSerializer());
        mapper.registerModule(module);
    }

    public String countOccurrencesAndSortDesc(String string) throws JsonProcessingException {
        Map<Character, Integer> resultMap = countOccurrences(string);
        return mapper.writeValueAsString(resultMap);
    }

    private Map<Character, Integer> countOccurrences(String string) {
        Map<Character, Integer> resultMap = new TreeMap<>();
        for (int i = 0; i < string.length(); i++){
            if (resultMap.containsKey(string.charAt(i))) {
                resultMap.put(string.charAt(i), resultMap.get(string.charAt(i)) + 1);
            } else {
                resultMap.put(string.charAt(i), 1);
            }
        }
        return resultMap;
    }
}
