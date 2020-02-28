package com.satooru.jasonSays;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.satooru.jasonSays.controller.QuoteController;

@SpringBootTest
class JasonSaysApplicationTests {

    @Autowired
    private QuoteController quoteController;

    @Test
    void contextLoads() throws Exception{
        assertTrue(quoteController != null);
    }

}
