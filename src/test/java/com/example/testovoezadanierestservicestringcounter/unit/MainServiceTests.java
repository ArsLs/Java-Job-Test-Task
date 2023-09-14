package com.example.testovoezadanierestservicestringcounter.unit;

import com.example.testovoezadanierestservicestringcounter.services.MainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MainServiceTests {
    private MainService mainService;

    @Autowired
    public MainServiceTests(MainService mainService){
        this.mainService = mainService;
    }

    @Test
    public void countOccurrencesNormalInputTest() throws JsonProcessingException {
        String input = ".,//авафывоdddddaaaaaacfyvguhbijnokmnjibhugvytfgubhijokmpmknojihbyugvytfcdrfyguihojnkhbgvutyfguhiojkpimnjohuibygvtfguhiojkpjohuygftausgdhiojiasiodhiausfавафывоdddddaaaaaacfyvguhbijnokmnjibhugvytfgubhijokmpmknojihbyugvytfcdrfyguihojnkhbgvutyfguhiojkpimnjohuibygvtfguhiojkpjohuygftausgdhiojiasiod";
        String output = mainService.countOccurrencesAndSortDesc(input);
        assertEquals(output, """
                {"i":25,"u":23,"h":23,"g":22,"o":20,"j":20,"a":17,"y":16,"d":16,"f":15,"k":12,"b":12,"v":10,"t":10,"n":10,"m":8,"p":6,"s":5,"в":4,"а":4,"c":4,"ы":2,"ф":2,"о":2,"r":2,"/":2,".":1,",":1}"""
        );
    }

    @Test
    public void countOccurrencesEmptyString() throws JsonProcessingException {
        String input = "";
        String output = mainService.countOccurrencesAndSortDesc(input);
        assertEquals(output, "{}");
    }

}
