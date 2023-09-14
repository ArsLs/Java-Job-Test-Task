package com.example.testovoezadanierestservicestringcounter.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CustomMapSerializer<K, V> extends JsonSerializer<TreeMap<Character, Integer>> {

    @Override
    public void serialize(TreeMap<Character, Integer> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        //This function looks awful, but Map.Entry.comparingByValue().reversed() refuses to work here, i don't understand why
        List<Map.Entry<Character, Integer>> sortedList = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();
        Map.Entry<Character, Integer> tmp;
        for (int i = sortedList.size()-1; i >= 0; i--) {
            try {
                tmp = sortedList.get(i);
                jsonGenerator.writeNumberField(tmp.getKey().toString(), tmp.getValue());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        jsonGenerator.writeEndObject();
    }
}


